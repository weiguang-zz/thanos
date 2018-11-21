package com.thanos.portal.rest.advice;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

import com.google.gson.Gson;
import com.thanos.common.domain.exception.ApplicationException;
import com.thanos.common.domain.exception.AuthorizationException;
import com.thanos.common.domain.exception.BusinessException;
import com.thanos.common.domain.exception.IllegalInputException;
import com.thanos.common.domain.exception.ResultCase;
import com.thanos.common.domain.exception.ResultCase.Id;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * Create by zhangzheng on 9/8/18
 * Email:zhangzheng@youzan.com
 */
@Slf4j
@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class MyHanderExceptionResolver implements HandlerExceptionResolver {
  private Gson gson = new Gson();
  private static final HttpHeaders EMPTY_HEADERS = new HttpHeaders();
  @Override
  public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) {
    logError(ex, request);
    //todo need test
    if(ex instanceof IllegalInputException){
      writeErrorResponse(((IllegalInputException) ex).resultCase(), UNPROCESSABLE_ENTITY, EMPTY_HEADERS, response);
    }
    if(ex instanceof MultipartException){
      writeErrorResponse(new ResultCase(Id.illegal_input, ex.getMessage()), UNPROCESSABLE_ENTITY, EMPTY_HEADERS, response);
    }
    if(ex instanceof BusinessException){
      writeErrorResponse(((BusinessException) ex).resultCase(), UNPROCESSABLE_ENTITY, EMPTY_HEADERS, response);
    }
    if(ex instanceof AuthorizationException){
      writeErrorResponse(((AuthorizationException) ex).resultCase(), UNAUTHORIZED, EMPTY_HEADERS, response);
    }
    if(ex instanceof ApplicationException){
      writeErrorResponse(((ApplicationException) ex).resultCase(), INTERNAL_SERVER_ERROR, EMPTY_HEADERS, response);
    }
    writeErrorResponse(new ResultCase(Id.internal_error, ex.getMessage()), INTERNAL_SERVER_ERROR, EMPTY_HEADERS, response);

    return new ModelAndView();//触发exception resolver chain break
  }

  private void logError(Throwable e, HttpServletRequest request) {
    log.error(
        String.format(
            "Exception occurred while processing request: %s %s",
            request.getMethod(), request.getRequestURI()),
        e);
  }

  protected void writeErrorResponse(Object body, HttpStatus status, HttpHeaders headers, HttpServletResponse response){
    try {
      response.setStatus(status.value());
      response.getWriter().append(gson.toJson(body));
      for(String headerName:headers.keySet()){
        headers.get(headerName).stream().forEach(val -> response.setHeader(headerName, val));
      }
      response.flushBuffer();
    } catch (Exception e) {
      log.error("write error response error",e);
    }


  }


}
