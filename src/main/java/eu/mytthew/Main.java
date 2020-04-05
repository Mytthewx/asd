package eu.mytthew;


public class Main {
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.add(9);
		bst.add(7);
		bst.add(8);
		bst.add(6);
		bst.add(5);
		bst.add(13);
		bst.add(14);
		bst.add(12);
		bst.add(11);
		bst.display();
		System.out.println(bst.remove(7));
		bst.display();
	}
}
