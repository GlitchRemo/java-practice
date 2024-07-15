package com.tw.step9;

import java.util.ArrayList;
import java.util.List;

public class Demo {
  private final Logger logger;
  public List<Intern> interns = new ArrayList<>();

  public Demo(Logger logger) {
    this.logger = logger;
  }

  List<Intern> addInterns(Intern intern) {
    interns.add(intern);
    return interns;
  }

  void throwError() {

  }
}

