package eu.mytthew;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Heap<Person> heap = new Heap<>();
		new Random().ints(10, 1, 80).mapToObj(Person::new).forEach(heap::add);
		heap.display();
	}
}
