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

	public E get(int value) {
		Node node = tree.get(value);
		return node.value;
	}

	public void upHeap() {
		int indexOfNode = tree.size() - 1;
		int parent = (indexOfNode - 1) / 2;
		System.out.println(tree);
		while (tree.get(indexOfNode).value.compareTo(tree.get(parent).value) < 0 && indexOfNode > 0) {
			Node temp = tree.get(indexOfNode);
			tree.set(indexOfNode, tree.get(parent));
			tree.set(parent, temp);
			indexOfNode = parent;
			parent = (indexOfNode - 1) / 2;
		}
		System.out.println(tree);
	}

//	public void downHeap() {
//		int indexOfNode = tree.size() - 1;
//		int parent = (indexOfNode - 1) / 2;
//		while (tree.get(indexOfNode).compareTo(tree.get(parent)) > 0 && indexOfNode > 0) {
//			Node temp = tree.get(indexOfNode);
//			tree.set(indexOfNode, tree.get(parent));
//			tree.set(parent, temp);
//			indexOfNode = parent;
//			parent = (indexOfNode - 1) / 2;
//		}
//}

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
