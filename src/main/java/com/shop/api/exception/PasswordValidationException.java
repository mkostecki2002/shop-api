package com.shop.api.exception;

public class PasswordValidationException extends RuntimeException {
  public PasswordValidationException(String message) {
    super(message);
  }
}
