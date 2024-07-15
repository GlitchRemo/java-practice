package com.tw.step9.models;

public class PositionAlreadyOccupiedException extends Throwable {
  public PositionAlreadyOccupiedException() {
    super("Position Already Occupied");
  }
}
