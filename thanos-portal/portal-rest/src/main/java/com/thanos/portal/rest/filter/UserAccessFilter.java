package com.thanos.portal.rest.filter;

import com.google.gson.Gson;
import com.thanos.common.domain.exception.ResultCase;
import com.thanos.common.domain.exception.ResultCase.Id;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by zhangzheng on 8/31/18
 * Email:zhangzheng@youzan.com
 */
public class UserAccessFilter implements javax.servlet.Filter {

  private static final String LOGIN_URL = "/login";
  private Gson gson = new Gson();
  public static final String LOGINED_USER = "loginedUser";

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    String requestUri = ((HttpServletRequest) servletRequest).getRequestURI();
    if(isLoginUrl(requestUri)){
      filterChain.doFilter(servletRequest, servletResponse);
    }else {
      Object user = ((HttpServletRequest) servletRequest).getSession().getAttribute(LOGINED_USER);
      if(user==null){
        writeForbiddenResponse(servletResponse);
        return;
      }
      filterChain.doFilter(servletRequest, servletResponse);
    }
  }

  private boolean isLoginUrl(String url){
    if(url.trim().equals(LOGIN_URL)) return true;
    return false;
  }

  private void writeForbiddenResponse(ServletResponse servletResponse) throws IOException {
    ((HttpServletResponse)servletResponse).setStatus(HttpServletResponse.SC_FORBIDDEN);
    PrintWriter printWriter = servletResponse.getWriter();
    String body = gson.toJson(new ResultCase(Id.access_deny, "user not login"));
    printWriter.append(body);
    printWriter.flush();
  }


  @Override
  public void destroy() {

  }
}
