package eu.mytthew;

import java.util.HashMap;
import java.util.Map;

public class CountingSort {
	public static void countingSort(int[] array) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int value : array) {
			if (!map.containsKey(value)) {
				map.put(value, 0);
			}
			map.put(value, map.get(value) + 1);
		}
		int v = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int i = entry.getValue();
			while (i > 0) {
				array[v++] = entry.getKey();
				i--;
			}
		}
	}
}
