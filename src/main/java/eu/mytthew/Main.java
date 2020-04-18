package eu.mytthew;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		System.out.println("Original array: " + Arrays.toString(array));
		mergeSort.mergeSort(array);
		System.out.println("New array: " + Arrays.toString(array));
	}
}
