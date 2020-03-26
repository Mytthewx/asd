package eu.mytthew;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class BinarySearchTree {
	private Node root;

	@Getter
	@Setter
	@EqualsAndHashCode
	private class Node {
		private int value;
		private Node left;
		private Node right;

		public Node(int value) {
			this.value = value;
		}


		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	public void add(int value) {
		Node inserting = new Node(value);
		if (root == null) {
			root = inserting;
			return;
		}
		Node walking = root;
		while (true) {
			if (walking.value < inserting.value) {
				if (walking.right == null) {
					walking.right = inserting;
					return;
				}
				walking.right = walking;
			} else if (walking.value > inserting.value) {
				if (walking.left == null) {
					walking.left = inserting;
					return;
				}
				walking.left = walking;
			}
		}
	}

	public void display() {
		Node walking = root;
		while (walking != null) {
			walking = walking.left;
			System.out.println(walking.value);
		}
	}


}
