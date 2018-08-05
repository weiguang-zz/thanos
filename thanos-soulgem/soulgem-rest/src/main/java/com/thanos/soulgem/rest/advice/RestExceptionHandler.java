package com.thanos.soulgem.rest.advice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

import com.thanos.soulgem.domain.exception.ApplicationException;
import com.thanos.soulgem.domain.exception.BusinessException;
import com.thanos.soulgem.domain.exception.IllegalInputException;
import com.thanos.soulgem.domain.exception.ResultCase;
import com.thanos.soulgem.domain.exception.ResultCase.Id;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

  private static final HttpHeaders EMPTY_HEADERS = new HttpHeaders();

  @ExceptionHandler({IllegalInputException.class})
  public final ResponseEntity<Object> handleIllegalInputException(
      IllegalInputException ex, HttpServletRequest request, WebRequest webReq) {
    logError(ex, request);
    return handleExceptionInternal(
        ex, ex.resultCase(), EMPTY_HEADERS, UNPROCESSABLE_ENTITY, webReq);
  }

  @ExceptionHandler({MultipartException.class})
  public final ResponseEntity<Object> handleUploadException(
      MultipartException ex, HttpServletRequest request, WebRequest webReq) {
    logError(ex, request);
    return handleExceptionInternal(
        ex, new ResultCase(Id.illegal_input, ex.getMessage()), EMPTY_HEADERS, BAD_REQUEST, webReq);
  }

  @ExceptionHandler({BusinessException.class})
  public final ResponseEntity<Object> handleBusinessException(
      BusinessException ex, HttpServletRequest request, WebRequest webReq) {
    logError(ex, request);
    return handleExceptionInternal(
        ex, ex.resultCase(), EMPTY_HEADERS, UNPROCESSABLE_ENTITY, webReq);
  }

  @ExceptionHandler({ApplicationException.class})
  public final ResponseEntity<Object> handleApplicationException(
      ApplicationException ex, HttpServletRequest request, WebRequest webReq) {
    logError(ex, request);
    return handleExceptionInternal(
        ex, ex.resultCase(), EMPTY_HEADERS, INTERNAL_SERVER_ERROR, webReq);
  }

  @ExceptionHandler(Throwable.class)
  public ResponseEntity<Object> handleOthers(
      Throwable ex, HttpServletRequest request, WebRequest weReq) {
    logError(ex, request);
    ApplicationException exWrapper =
        new ApplicationException(Id.internal_error, "Unexpected error", ex);
    return handleExceptionInternal(
        exWrapper, exWrapper.resultCase(), EMPTY_HEADERS, INTERNAL_SERVER_ERROR, weReq);
  }

  private void logError(Throwable e, HttpServletRequest request) {
    logger.error(
        String.format(
            "Exception occurred while processing request: %s %s",
            request.getMethod(), request.getRequestURI()),
        e);
  }
}
