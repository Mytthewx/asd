package eu.mytthew;

public class Main {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(15);
		bst.add(7);
		bst.add(10);
		bst.add(11);
		bst.add(9);
		bst.display();
		System.out.println("removeMax = " + bst.removeMax(10));
	}
}
