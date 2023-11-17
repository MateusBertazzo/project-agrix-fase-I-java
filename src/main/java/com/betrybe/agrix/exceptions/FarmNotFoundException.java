package com.betrybe.agrix.exceptions;

/**
 * Farm not found exception.
 */
public class FarmNotFoundException extends RuntimeException {
  public FarmNotFoundException(String messageError) {
    super(messageError);
  }
}
