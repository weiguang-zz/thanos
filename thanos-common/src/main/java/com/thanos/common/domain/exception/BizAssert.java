package com.thanos.common.domain.exception;


import com.thanos.common.domain.exception.ResultCase.Id;

/**
 * Util for asserting business constraint conditions
 */
public final class BizAssert {

  private BizAssert() {
  }

  /**
   * Asserts that the given condition is met, otherwise throw a {@link BusinessException} with the
   * given message.
   *
   * @param condition the constraint condition to check
   * @param message the exception message to use if the check fails
   */
  public static final void check(boolean condition, String message) {
    if (!condition) {
      throw new BusinessException(message);
    }
  }

  /**
   * Asserts that the given condition is met, otherwise throw a {@link BusinessException} with the
   * given message.
   *
   * @param condition the constraint condition to check
   * @param msgTemplate a template for the exception message if the check fail
   * @param msgArgs the arguments to be substituted into the message template.
   */
  public static final void check(boolean condition, String msgTemplate, Object... msgArgs) {
    check(condition, String.format(msgTemplate, msgArgs));
  }

  public static final void check(boolean condition, Id id, String message) {
    if (!condition) {
      throw new BusinessException(id, message);
    }
  }

  public static final void check(
      boolean condition, Id id, String msgTemplate, Object... msgArgs) {
    check(condition, id, String.format(msgTemplate, msgArgs));
  }
}
