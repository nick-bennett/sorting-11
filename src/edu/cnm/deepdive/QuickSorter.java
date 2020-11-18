package edu.cnm.deepdive;

public class QuickSorter implements Sorter {

  @Override
  public void sort(int[] data, int lowerBound, int upperBound) {
    if (upperBound > lowerBound + 1) {
      int pivotPosition = (lowerBound + upperBound) / 2;
      int pivotValue = data[pivotPosition];
      data[pivotPosition] = data[lowerBound];
      data[lowerBound] = pivotValue;
      int partitionIndex = lowerBound;
      for (int currentIndex = lowerBound; currentIndex < upperBound; currentIndex++) {
        int currentValue = data[currentIndex];
        if (currentValue < pivotValue) {
          if (currentIndex > partitionIndex) {
            data[currentValue] = data[partitionIndex];
            data[partitionIndex] = currentValue;
          }
          partitionIndex++;
        }
      }
      data[lowerBound] = data[partitionIndex - 1];
      data[partitionIndex - 1] = pivotValue;
      sort(data, lowerBound, partitionIndex - 1);
      sort(data, partitionIndex, upperBound);
    }
  }

}
