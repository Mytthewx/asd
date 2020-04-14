package eu.mytthew;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Heap<Person> heap = new Heap<>();
		new Random().ints(1000, 0, 100).mapToObj(Person::new).forEach(heap::add);
		int i = 1;
		while (heap.size() > 0) {
			System.out.println(i + ": " + heap.get());
			i++;
		}
	}
}
