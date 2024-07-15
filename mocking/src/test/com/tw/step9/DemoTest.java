package com.tw.step9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.mockito.Mockito.*;

class DemoTest {
  @Test
  void demo() {
    List mockedList = mock(List.class);
    ArgumentCaptor<Integer> argument = ArgumentCaptor.forClass(Integer.class);

    when(mockedList.get(0)).thenReturn("first");
    when(mockedList.get(1)).thenThrow(new RuntimeException());

    Assertions.assertEquals(mockedList.get(0), "first");
    Assertions.assertThrows(RuntimeException.class, () -> mockedList.get(1));

    verify(mockedList, times(2)).get(argument.capture());
    Assertions.assertEquals(1, argument.getValue());
  }
}