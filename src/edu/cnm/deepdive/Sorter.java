package edu.cnm.deepdive;

public interface Sorter {

  default void sort(int[] data) {
    sort(data, 0, data.length);
  }

  void sort(int[] data, int lowerBound, int upperBound);

}
