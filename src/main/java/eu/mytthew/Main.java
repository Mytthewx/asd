package eu.mytthew;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		RadixSort radixSort = new RadixSort();
		int[] array = {625, 1, 364, 723, 662, 98, 10, 11, 2, 1};
		System.out.println(Arrays.toString(array));
		radixSort.radixSort(array);
		System.out.println(Arrays.toString(array));
	}
}
