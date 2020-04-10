package eu.mytthew;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


public class Heap<E extends Comparable<E>> {
	List<Node> tree = new ArrayList<>();

	@Data
	@Getter
	@Setter
	@EqualsAndHashCode
	private class Node implements Comparable<Node> {
		final E value;

		public Node(E value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}

		@Override
		public int compareTo(Node node) {
			return 0;
		}
	}

	public void add(E value) {
		Node node = new Node(value);
		tree.add(node);
		if (tree.size() > 1) {
			upHeap();
		}
	}

	public E get() {
		E root = tree.get(0).value;
		int indexOfLast = tree.size() - 1;
		tree.set(0, tree.get(indexOfLast));
		tree.remove(indexOfLast);
		downHeap();
		return root;
	}

	private void upHeap() {
		int indexOfNode = tree.size() - 1;
		int parent = (indexOfNode - 1) / 2;
		while ((tree.get(parent).value).compareTo(tree.get(indexOfNode).value) > 0 && indexOfNode > 0) {
			Node temp = tree.get(indexOfNode);
			tree.set(indexOfNode, tree.get(parent));
			tree.set(parent, temp);
			indexOfNode = parent;
			parent = (indexOfNode - 1) / 2;
		}
	}

	private void downHeap() {
		int parent = 0;
		int smallerChild = getSmaller(parent);
		if (tree.get(parent).value.compareTo(tree.get(smallerChild).value) > 0 && smallerChild > 0) {
			Node temp = tree.get(parent);
			tree.set(parent, tree.get(smallerChild));
			tree.set(smallerChild, temp);
		}
	}

	private int getSmaller(int index) {
		int leftChild = (2 * index) + 1;
		int rightChild = (2 * index) + 2;
		if (tree.get(leftChild).compareTo(tree.get(rightChild)) < 0) {
			return leftChild;
		}
		return rightChild;
	}

	public void display() {
		int target = 1;
		int current = 0;
		for (Node n : tree) {
			if (current++ == target) {
				System.out.println();
				target <<= 1;
				current = 1;
			}
			System.out.print(n);
		}
	}
}
