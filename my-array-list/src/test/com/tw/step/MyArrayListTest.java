package com.tw.step;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyArrayListTest {
  private MyArrayList<Integer> numbers;
  @BeforeEach
  void setUp() {
    numbers = new MyArrayList<>();
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
    numbers.add(4);
  }

  @Test
  void map() {
    List<Integer> mappedNumbers = numbers.map(a -> a + 1);
    assertEquals(mappedNumbers, List.of(2, 3, 4, 5), "Increment each number of an array by one");
  }

  @Test
  void filter() {
    List<Integer> evenNumbers = numbers.filter(a -> a % 2 == 0);
    assertEquals(evenNumbers, List.of(2, 4));
  }

  @Test
  void reduce() {
    int sum = numbers.reduce(0, Integer::sum);
    assertEquals(sum, 10);
  }

  @Test
  void reduceWithoutContext() {
    int sum = numbers.reduce(Integer::sum);
    assertEquals(sum, 10);
  }

  @Test
  void some() {
    boolean contains = numbers.some(a -> a == 2);
    assertTrue(contains);
  }

  @Test
  void find() {
    int two = numbers.find(a -> a == 2);
    assertEquals(two, 2);
  }
}