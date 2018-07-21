package com.thanos.soulgem.domain.exception;

public final class ResultCase {

  private final Id id;
  private final String message;

  public ResultCase(Id id, String message) {
    this.id = id;
    this.message = message;
  }

  public final Id id() {
    return id;
  }

  public final String message() {
    return message;
  }

  public enum Id {
    ok,
    illegal_input,
    biz_constraint_violated,
    upload_io_error,
    entity_absent,
    internal_error
  }
}
