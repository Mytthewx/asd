package eu.mytthew;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		BinarySearch binarySearch = new BinarySearch();
		int[] array = {1, 1, 2, 2, 4, 5, 7, 8};
		System.out.println(Arrays.toString(array));
		System.out.println("Exist: " + binarySearch.binarySearch(array, 3));
	}
}
