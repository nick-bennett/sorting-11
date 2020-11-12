package edu.cnm.deepdive;

import java.util.Arrays;

public class MergeSorter {

  public void sort(int[] data) {
    sort(data, 0, data.length);
    Arrays.sort(data);
  }

  public void sort(int[] data, int lowerBound, int upperBound) {
    if (upperBound > lowerBound + 1) {
      int midpoint = (upperBound + lowerBound) / 2;
      sort(data, lowerBound, midpoint);
      sort(data, midpoint, upperBound);
      int[] merged = new int[upperBound - lowerBound];
      int leftIndex = lowerBound;
      int rightIndex = midpoint;
      int mergedIndex = 0;
      while (leftIndex < midpoint && rightIndex < upperBound) {
        int leftValue = data[leftIndex];
        int rightValue = data[rightIndex];
        if (leftValue <= rightValue) {
          merged[mergedIndex] = leftValue;
          leftIndex++;
        } else {
          merged[mergedIndex] = rightValue;
          rightIndex++;
        }
        mergedIndex++;
      }
      if (leftIndex < midpoint) {
        System.arraycopy(data, leftIndex, merged, mergedIndex, midpoint - leftIndex);
      } else {
        System.arraycopy(data, rightIndex, merged, mergedIndex, upperBound - rightIndex);
      }
      System.arraycopy(merged, 0, data, lowerBound, merged.length);
    }
  }

}
