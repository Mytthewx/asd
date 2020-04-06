package eu.mytthew;


public class Main {
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.add(8);
		bst.add(4);
		bst.add(12);
		bst.add(2);
		bst.add(6);
		bst.add(1);
		bst.add(3);
		bst.add(5);
		bst.add(10);
		bst.add(14);
		bst.add(9);
		bst.add(11);
		bst.add(13);
		bst.add(15);
		bst.display();
		System.out.println(bst.remove(8));
		bst.display();
	}
}
