package eu.mytthew;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Heap<E extends Comparable<E>> {
	List<Node> tree = new ArrayList<>();

	@Data
	@Getter
	@Setter
	@EqualsAndHashCode
	private class Node implements Comparable<Node> {
		private final E value;

		private Node(E value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}

		@Override
		public int compareTo(Node node) {
			return value.compareTo(node.value);
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
		if (tree.isEmpty()) {
			throw new NoSuchElementException("Size is 0.");
		}
		Node root = tree.get(0);
		if (tree.size() == 1) {
			tree.remove(0);
			return root.value;
		}
		tree.set(0, tree.get(tree.size() - 1));
		tree.remove(tree.size() - 1);
		downHeap();
		return root.value;
	}

	public int size() {
		return tree.size();
	}

	private boolean hasAnyChild(int index) {
		return tree.size() > (2 * index) + 1;
	}

	private void upHeap() {
		int indexOfNode = tree.size() - 1;
		int parent = (indexOfNode - 1) / 2;
		while ((tree.get(parent)).compareTo(tree.get(indexOfNode)) > 0 && indexOfNode > 0) {
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
		while (hasAnyChild(parent) && tree.get(parent).compareTo(tree.get(smallerChild)) > 0) {
			Node temp = tree.get(parent);
			tree.set(parent, tree.get(smallerChild));
			tree.set(smallerChild, temp);
			parent = smallerChild;
			smallerChild = getSmaller(parent);
		}
	}

	private int getSmaller(int index) {
		int leftChild = (2 * index) + 1;
		int rightChild = (2 * index) + 2;
		if (rightChild >= tree.size() || tree.get(rightChild).compareTo(tree.get(leftChild)) > 0) {
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
		System.out.println();
	}
}
