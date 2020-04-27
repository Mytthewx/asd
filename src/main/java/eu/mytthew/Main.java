package eu.mytthew;

import java.util.Arrays;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		int[] array = new Random().ints(100, 1, 10).toArray();
		System.out.println(Arrays.toString(array));
		quickSort.quickSort(array);
		System.out.println(Arrays.toString(array));
	}
}
