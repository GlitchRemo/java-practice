package com.thoughtworks.step.operations;

import io.github.saumasaha.math.number.Real;

public class Operations {
  public Real power(Real n) {
    return new Real(n.value() * n.value());
  }
}