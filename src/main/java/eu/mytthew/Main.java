package eu.mytthew;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		RadixSort radixSort = new RadixSort();
		int[] array = {923, 625, 1, 364, 723, 662, 98};
		System.out.println(Arrays.toString(array));
		radixSort.radixSort(array);
	}
}
