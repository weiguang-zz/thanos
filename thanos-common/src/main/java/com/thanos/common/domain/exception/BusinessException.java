package com.thanos.common.domain.exception;


import com.thanos.common.domain.exception.ResultCase.Id;

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
