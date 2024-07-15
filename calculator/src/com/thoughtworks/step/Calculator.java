package com.thoughtworks.step;
import io.github.saumasaha.math.number.Real;

class Calculator {
  public static void main(String[] args) {
    Real two = new Real(2);
    Real three = new Real(3);

    Real five = two.add(three);
    System.out.println(five);
  }
}