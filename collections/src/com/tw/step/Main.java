package com.tw.step;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
  private static ArrayList<String> eligibleForVote(Set<Intern> interns, IsEligibleForVote isEligibleForVote) {
    ArrayList<String> eligibleInterns = new ArrayList<>();

    for (Intern intern : interns) {
      if (isEligibleForVote.test(intern))
        eligibleInterns.add(intern.getName());
    }

    return eligibleInterns;
  }

  private static void printEligibleInterns() {
    Set<Intern> interns = new HashSet<>();

    interns.add(new Intern("riya", 23));
    interns.add(new Intern("priya", 22));
    interns.add(new Intern("priya", 17));
    IsEligibleForVote isEligibleForVote = new IsEligibleForVote();

    System.out.println(eligibleForVote(interns, isEligibleForVote));

    interns.removeIf(isEligibleForVote);
    System.out.println(interns);
  }

  public static void main(String[] args) {
    Map<Character, Integer> counts = FrequencyTable.getCounts("Hello World");
    System.out.println(counts);
  }
}
