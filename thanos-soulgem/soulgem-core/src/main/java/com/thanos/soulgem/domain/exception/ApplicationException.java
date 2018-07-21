package com.thanos.soulgem.domain.exception;


import com.thanos.soulgem.domain.exception.ResultCase.Id;

public class ApplicationException extends RuntimeException {

  private final ResultCase resultCase;

  public ApplicationException(Id id, String message) {
    this(new ResultCase(id, message));
  }

  public ApplicationException(Id id, String message, Throwable cause) {
    this(new ResultCase(id, message), cause);
  }

  public ApplicationException(ResultCase resultCase) {
    super(resultCase.message());
    this.resultCase = resultCase;
  }

  public ApplicationException(ResultCase resultCase, Throwable cause) {
    super(resultCase.message(), cause);
    this.resultCase = resultCase;
  }

  public ResultCase resultCase() {
    return resultCase;
  }
}
