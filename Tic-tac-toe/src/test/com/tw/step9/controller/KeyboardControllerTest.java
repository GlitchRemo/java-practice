package com.tw.step9.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class KeyboardControllerTest {
  @Test
  void shouldReturnAnInteger() {
    Scanner sc = mock(Scanner.class);
    KeyboardController keyboardController = new KeyboardController(sc);

    when(sc.nextInt()).thenReturn(1);

    Assertions.assertEquals(keyboardController.nextInput(), 1);
  }
}