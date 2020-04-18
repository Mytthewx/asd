package eu.mytthew;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		CountingSort countingSort = new CountingSort();
		int[] array = {3, 2, 1, 3, 2, 10};
		System.out.println(Arrays.toString(array));
		countingSort.countingSort(array);
		System.out.println(Arrays.toString(array));
	}
}
