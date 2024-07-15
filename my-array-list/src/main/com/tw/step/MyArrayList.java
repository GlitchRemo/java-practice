package com.tw.step;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MyArrayList<T> extends ArrayList<T> {
  public MyArrayList(Collection<? extends T> c) {
    super(c);
  }

  public MyArrayList() {
  }

  public <R> List<R> map(Function<T, R> mapper) {
    List<R> newList = new ArrayList<>();

    for (T element: this) {
      newList.add(mapper.apply(element));
    }

    return newList;
  }

  public List<T> filter(Function<T, Boolean> predicate) {
    List<T> newList = new ArrayList<>();

    for (T element: this) {
      if(predicate.apply(element)) {
        newList.add(element);
      }
    }

    return newList;
  }

  public <K> K reduce(K context, BiFunction<K,T,K> reducer) {
    K copyContext =  context;

    for (T element: this) {
      copyContext = reducer.apply(copyContext, element);
    }

    return copyContext;
  }

  public T reduce(BiFunction<T, T, T> reducer) {
    T copyContext =  this.get(0);

    for (T element: this.subList(1, this.size())) {
      copyContext = reducer.apply(copyContext, element);
    }

    return copyContext;
  }

  public boolean some(Function<T, Boolean> callbackFn) {
    for (T element: this) {
      if(callbackFn.apply(element)) {
        return true;
      }
    }

    return false;
  }

  public T find(Function<T, Boolean> callbackFn) {
    for (T element: this) {
      if(callbackFn.apply(element)) {
        return element;
      }
    }

    return null;
  }
}
