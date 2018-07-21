package com.thanos.soulgem.domain.exception;


import com.thanos.soulgem.domain.exception.ResultCase.Id;

public class BusinessException extends ApplicationException {

  public BusinessException(String message) {
    super(Id.biz_constraint_violated, message);
  }

  public BusinessException(Id id, String message) {
    super(id, message);
  }

  public BusinessException(Id id, String message, Throwable cause) {
    super(id, message, cause);
  }
}
