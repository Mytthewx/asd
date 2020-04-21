package eu.mytthew;

import java.util.List;
import java.util.Map;
import java.util.*;

public class RadixSort {
	public void radixSort(int[] array) {
		int max = findMax(array);
		int maxDigits = getNumberOfDigits(max);
		int divide = 1;
		for (int j = maxDigits; j > 0; j--) {
			Map<Integer, List<Integer>> map = new HashMap<>();
			for (int i = 0; i < 10; i++) {
				map.put(i, new ArrayList<>());
			}
			for (int value : array) {
				int valueAfterReduce = value / divide;
				int bucket = valueAfterReduce % 10;
				map.get(bucket).add(value);
			}
			divide *= 10;
			int[] sortedArray = map.values().stream()
					.flatMap(Collection::stream)
					.mapToInt(e -> e)
					.toArray();
			System.arraycopy(sortedArray, 0, array, 0, array.length);
		}
	}

	private int findMax(int[] array) {
		int max = array[0];
		for (int value : array) {
			if (value > max) {
				max = value;
			}
		}
		return max;
	}

	private int getNumberOfDigits(int number) {
		int count = 0;
		while (number != 0) {
			number /= 10;
			count++;
		}
		return count;
	}
}
