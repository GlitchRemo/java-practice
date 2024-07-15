package com.tw.step9.models;

public class InvalidMoveException extends Throwable {
  public InvalidMoveException() {
    super("Invalid input. Please enter a number between 1-9");
  }
}
