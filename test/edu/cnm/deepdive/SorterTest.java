package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SorterTest {

  @SuppressWarnings("unused")
  private static Stream<Arguments> sort() {
    Random rng = new Random();
    return Stream.generate(() -> singleCase(rng, 50))
        .limit(10);
  }

  private static Arguments singleCase(Random rng, int length) {
    int[] data = IntStream.generate(rng::nextInt)
        .limit(length)
        .toArray();
    int[] expected = Arrays.copyOf(data, data.length);
    Arrays.sort(expected);
    return Arguments.of(data, expected);
  }

  @ParameterizedTest
  @MethodSource
  void sort(int[] input, int[] expected) {
    int[] merge = Arrays.copyOf(input, input.length);
    int[] quick = Arrays.copyOf(input, input.length);
    new MergeSorter().sort(merge);
    assertArrayEquals(expected, merge);
    new QuickSorter().sort(quick);
    assertArrayEquals(expected, quick);
  }


}