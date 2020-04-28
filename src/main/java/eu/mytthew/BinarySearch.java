package eu.mytthew;

public class BinarySearch {
	public boolean binarySearch(int[] array, int value) {
		return binarySearch(array, 0, array.length - 1, value);
	}

	public boolean binarySearch(int[] array, int low, int high, int value) {
		while (low <= high) {
			int mid = (low + high);
			int midValue = array[mid];
			if (midValue == value) {
				return true;
			}
			if (midValue > value) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return false;
	}
}
