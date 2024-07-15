package com.tw.step9.controller;

import java.util.Scanner;

public class KeyboardController implements InputController {
  Scanner scanner;

  public KeyboardController(Scanner scanner) {
    this.scanner = scanner;
  }

  public int nextInput() {
    System.out.print("Enter a number between 1-9: ");
    return this.scanner.nextInt();
  }

  public void consumeInput() {
    this.scanner.next();
  }
}
