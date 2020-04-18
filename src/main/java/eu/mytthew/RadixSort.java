package eu.mytthew;

import java.util.List;
import java.util.Map;
import java.util.*;

public class RadixSort {
	public void sort(int[] array) {
		radixSort(array);
		System.out.println("Inner toString: " + Arrays.toString(array));
	}

	public void radixSort(int[] array) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			map.put(i, new ArrayList<>());
		}
		int[] newArray = Arrays.copyOf(array, array.length);
		for (int value : newArray) {
			int lastDigit = getLastDigit(value);
			for (int j = 0; j < 10; j++) {
				if (j == lastDigit) {
					map.get(j).add(value);
				}
			}
		}
	}

	private int getLastDigit(int number) {
		return number % 10;
	}

	private int[] reduceNumbers(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] /= 10;
		}
		return array;
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

	private int getSpecificDigitOfNumber(int number, int digit) {
		String s = String.valueOf(number);
		if (digit < getNumberOfDigits(number)) {
			char ch = s.charAt(digit);
			return ch - '0';
		}
		return 0;
	}
}
