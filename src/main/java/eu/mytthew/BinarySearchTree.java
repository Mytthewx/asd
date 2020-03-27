package eu.mytthew;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

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
				walking = walking.right;
			} else if (walking.value > inserting.value) {
				if (walking.left == null) {
					walking.left = inserting;
					return;
				}
				walking = walking.left;
			}
		}
	}

	public void display() {
		display(root);
	}

	public void display(Node node) {
		if (node.left != null) {
			display(node.left);
		}
		System.out.println(node.value);
		if (node.right != null) {
			display(node.right);
		}
	}

	public boolean contains(int value) {
		Node walking = root;
		while (walking != null) {
			if (Objects.equals(walking.value, value)) {
				return true;
			}
			if (walking.value < value) {
				walking = walking.right;
			} else {
				walking = walking.left;
			}
		}
		return false;
	}
}
