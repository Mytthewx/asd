package eu.mytthew;

public class Main {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(9);
		bst.add(7);
		bst.add(10);
		bst.add(6);
		bst.add(8);
		bst.add(5);
		bst.add(11);
		bst.display();
		for (int i = 1; i <= 12; i++) {
			System.out.println("" + i + " " + bst.contains(i));
		}
	}
}
