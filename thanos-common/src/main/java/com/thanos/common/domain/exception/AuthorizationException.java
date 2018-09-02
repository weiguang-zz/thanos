package com.thanos.common.domain.exception;

import com.thanos.common.domain.exception.ResultCase.Id;

/**
 * Create by zhangzheng on 8/31/18
 * Email:zhangzheng@youzan.com
 */
public class AuthorizationException extends ApplicationException {

  public AuthorizationException(String message) {
    super(Id.access_deny, message);
  }

  public AuthorizationException(Id id, String message) {
    super(id, message);
  }

  public AuthorizationException(Id id, String message, Throwable cause) {
    super(id, message, cause);
  }


}
