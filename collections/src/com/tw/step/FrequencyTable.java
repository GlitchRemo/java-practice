package com.tw.step;

import java.util.HashMap;
import java.util.Map;

public class FrequencyTable {
  public static Map<Character, Integer> getCounts(String text) {
    Map<Character, Integer> frequencyTable = new HashMap<>();
    char[] characters = text.toCharArray();

    for (char c : characters) {
      frequencyTable.putIfAbsent(c, 0);
      int count = frequencyTable.get(c);
      frequencyTable.replace(c, count + 1);
    }

    return frequencyTable;
  }
}
