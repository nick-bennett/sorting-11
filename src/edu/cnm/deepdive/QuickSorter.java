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
      for (int currentIndex = lowerBound + 1; currentIndex < upperBound; currentIndex++) {
        int currentValue = data[currentIndex];
        if (currentValue <= pivotValue) {
          partitionIndex++;
          if (currentIndex > partitionIndex) {
            data[currentIndex] = data[partitionIndex];
            data[partitionIndex] = currentValue;
          }
        }
      }
      data[lowerBound] = data[partitionIndex];
      data[partitionIndex] = pivotValue;
      sort(data, lowerBound, partitionIndex);
      sort(data, partitionIndex + 1, upperBound);
    }
  }

}
