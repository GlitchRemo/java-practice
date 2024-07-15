package com.tw.step;

import java.util.Set;

public class Main {
  public static void main(String[] args) {
    MyHashMap<Character, Integer> myHashMap = new MyHashMap<>();
    myHashMap.put('a', 1);
    myHashMap.put('b', 2);

    Set<MyHashMap<Character, Integer>.Pair<Character, Integer>> entries = myHashMap.entrySet();
    Iterable<Integer> values = myHashMap.values();

    for (Integer value : values) {
      System.out.println(value);
    }
    System.out.println(entries);

    System.out.println("-------");

    myHashMap.put('c', 3);
    for (Integer value : values) {
      System.out.println(value);
    }
    System.out.println(entries);
//    System.out.println(values); // [1, 2, 3]

//    System.out.println(entries);
//    System.out.println(myHashMap.getCount());

//    myHashMap.put('c', 3);
//    System.out.println(entries);

//    OuterClass.staticFunction();
    OuterClass outerClass = new OuterClass();
//    outerClass.staticFunction();
    outerClass.sayGoodbyeInEnglish();
  }
}
