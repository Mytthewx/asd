package eu.mytthew;

public class QuickSort {
	public void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	public void quickSort(int[] array, int min, int max) {
		int left = min;
		int right = max;
		int middle = min + (max - min) / 2;
		int pivot = array[middle];
		while (left < right) {
			while (array[left] < pivot) {
				left++;
			}
			while (array[right] > pivot) {
				right--;
			}
			if (left <= right) {
				swap(array, left, right);
				left++;
				right--;
			}
		}
		if (min < right) {
			quickSort(array, min, right);
		}
		if (max > left) {
			quickSort(array, left, max);
		}
	}

	private void swap(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
}
