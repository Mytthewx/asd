package eu.mytthew;


public class Main {
	public static void main(String[] args) {
		Heap<Integer> heap = new Heap<>();
		heap.add(2);
		heap.add(1);
		heap.add(5);
		heap.add(4);
		heap.add(3);
		heap.add(9);
		heap.add(7);
		heap.add(-1);
		heap.display();
	}
}
