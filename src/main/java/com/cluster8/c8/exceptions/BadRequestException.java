package com.cluster8.c8.exceptions;

public class BadRequestException extends Exception {

  public BadRequestException() {
    super();
  }

  public BadRequestException(String message) {
    super(message);
  }
}
