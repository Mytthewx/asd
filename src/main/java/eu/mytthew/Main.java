package eu.mytthew;

public class Main {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		BinarySearchTree.Node node = new BinarySearchTree.Node(13);
		BinarySearchTree.Node node2 = new BinarySearchTree.Node(11);
		BinarySearchTree.Node node3 = new BinarySearchTree.Node(1242);
		BinarySearchTree.Node node4 = new BinarySearchTree.Node(-10);
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
		System.out.println("removeMin = " + bst.removeMin(node));
		System.out.println("removeMax = " + bst.removeMax(node));
		System.out.println("removeMin = " + bst.removeMin(node2));
		System.out.println("removeMax = " + bst.removeMax(node2));
		System.out.println("removeMin = " + bst.removeMin(node3));
		System.out.println("removeMax = " + bst.removeMax(node3));
		System.out.println("removeMin = " + bst.removeMin(node4));
		System.out.println("removeMax = " + bst.removeMax(node4));
	}
}


