package eu.mytthew;

import java.util.Arrays;

public class MergeSort {
	public static void mergeSort(int[] array) {
		if (array.length < 2) {
			return;
		}
		int mid = array.length / 2;
		int[] left = Arrays.copyOf(array, mid);
		int[] right = Arrays.copyOfRange(array, mid, array.length);
		mergeSort(left);
		mergeSort(right);
		int length = left.length + right.length;
		int[] newArray = new int[length];
		int leftIndex = 0;
		int rightIndex = 0;
		int i = 0;
		while (leftIndex < left.length && rightIndex < right.length) {
			if (left[leftIndex] <= right[rightIndex]) {
				newArray[i++] = left[leftIndex];
				leftIndex++;
			} else {
				newArray[i++] = right[rightIndex];
				rightIndex++;
			}
		}
		while (leftIndex < left.length) {
			newArray[i++] = left[leftIndex];
			leftIndex++;
		}
		while (rightIndex < right.length) {
			newArray[i++] = right[rightIndex];
			rightIndex++;
		}
		System.arraycopy(newArray, 0, array, 0, array.length);
	}
}
