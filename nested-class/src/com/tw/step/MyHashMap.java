package com.tw.step;

import java.util.*;

public class MyHashMap<K, V> {
  private final Set<Pair<K, V>> entries = new HashSet<>();
  private Collection<V> values;
  private int count = 0;

  public MyHashMap() {
    values = new Values();
  }

  public void put(K key, V value) {
    entries.add(new Pair<>(key, value));
  }

   public Set<Pair<K, V>> entrySet() {
    return entries;
  }

  public int getCount() {
    return count;
  }

  public Iterable<V> values() {
    Collection<V> vs = values;

    if(vs == null) {
      vs = new Values();
      values = vs;
    }

    return vs;
  }

  public class Pair<Key, Val> {
    private final Key key;
    private final Val value;

    public Pair(Key key, Val value) {
      this.key = key;
      this.value = value;
      count++;
    }

    @Override
    public String toString() {
      return "Pair{" +
          "key=" + key +
          ", value=" + value +
          '}';
    }
  }


  private class Values extends AbstractCollection<V> {

    @Override
    public Iterator<V> iterator() {
      return new ValueIterator();
    }

    @Override
    public int size() {
      return count;
    }

    private class ValueIterator implements Iterator<V> {
      Iterator<Pair<K, V>> iterator;
      public ValueIterator() {
         iterator = entries.iterator();
      }

      @Override
      public boolean hasNext() {
        return iterator.hasNext();
      }

      @Override
      public V next() {
        return iterator.next().value;
      }
    }
  }
}
