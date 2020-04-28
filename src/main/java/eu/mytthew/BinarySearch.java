package eu.mytthew;

public class BinarySearch {
	public boolean binarySearch(int[] array, int value) {
		return binarySearch(array, 0, array.length - 1, value);
	}

	public boolean binarySearch(int[] array, int min, int max, int value) {
		while (min <= max) {
			int middle = min + (max - min) / 2;
			if (array[middle] == value) {
				return true;
			}
			if (array[middle] > value) {
				return binarySearch(array, min, middle - 1, value);
			} else {
				return binarySearch(array, middle + 1, array.length - 1, value);
			}
		}
		return false;
	}
}
