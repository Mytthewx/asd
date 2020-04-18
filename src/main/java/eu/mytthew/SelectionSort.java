package eu.mytthew;

public class SelectionSort {
	public static void selectionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int temp = i;
			for (int j = i; j < array.length; j++) {
				if (array[j] < array[temp]) {
					temp = j;
				}
			}
			int temp2 = array[i];
			array[i] = array[temp];
			array[temp] = temp2;
		}
	}
}
