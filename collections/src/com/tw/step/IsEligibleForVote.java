package com.tw.step;

import java.util.function.Predicate;

public class IsEligibleForVote implements Predicate<Intern> {
  @Override
  public boolean test(Intern intern) {
    return intern.getAge() >= 18;
  }
}
