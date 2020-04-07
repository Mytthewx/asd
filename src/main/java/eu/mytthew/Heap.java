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
	}

	public E get(int value) {
		Node node = tree.get(value);
		return node.value;
	}

	public void upHeap() {
		int indexOfNode = tree.size() - 1;
		int parent = (indexOfNode - 1) / 2;
		while (tree.get(indexOfNode).compareTo(tree.get(parent)) < 0 && indexOfNode > 0) {
			Node temp = tree.get(indexOfNode);
			tree.set(indexOfNode, tree.get(parent));
			tree.set(parent, temp);
			indexOfNode = parent;
			parent = (indexOfNode - 1) / 2;
		}
	}


	public void display() {
		for (int i = 0; i < tree.size(); i++) {
			if ((Math.log(i) / Math.log(2)) % 1 < 0.00001) {
				System.out.println();
			}
			System.out.print(tree.get(i));
		}
	}
}
