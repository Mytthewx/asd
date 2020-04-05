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
	protected static class Node {
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
		if (root == null) {
			return;
		}
		display(root, "");
	}

	public void display(Node node, String string) {
		if (node.left != null) {
			display(node.left, string + "\t");
		}
		System.out.println(string + node.value);
		if (node.right != null) {
			display(node.right, string + "\t");
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


	public boolean remove(int value) {
		if (root == null) {
			return false;
		}
		if (Objects.equals(root.value, value)) {
			Node right = root.right;
			root = root.left;
			root.right = right;
		}
		Node walking = root;
		while (walking != null) {
			if (walking.right != null && Objects.equals(walking.right.value, value)) {
				if (walking.right.right == null && walking.right.left == null) {
					walking.right = null;
					return true;
				}
				if (walking.right.right == null) {
					walking.right = walking.right.left;
					return true;
				}
				if (walking.right.left == null) {
					Node min = removeMin(walking.right.right);
					if (min == null) {
						walking.right = walking.right.right;
					} else {
						walking.right = min;
					}
					return true;
				} else {
					Node min = removeMin(walking.right.right);
					Node left = walking.right.left;
					Node right = walking.right.right;
					if (min == null) {
						walking.right = walking.right.right;
						walking.right.left = left;
					} else {
						walking.right = min;
						walking.right.left = left;
						walking.right.right = right;
					}
					return true;
				}
			}
			if (walking.left != null && Objects.equals(walking.left.value, value)) {
				if (walking.left.right == null && walking.left.left == null) {
					walking.left = null;
					return true;
				}
				if (walking.left.right == null) {
					walking.left = walking.left.left;
					return true;
				}
				if (walking.left.left == null) {
					Node min = removeMin(walking.left.right);
					if (min == null) {
						walking.left = walking.left.right;
					} else {
						walking.left = min;
					}
					return true;
				} else {
					Node min = removeMin(walking.left.right);
					Node left = walking.left.left;
					Node right = walking.left.right;
					if (min == null) {
						walking.left = walking.left.right;
						walking.left.left = left;
					} else {
						walking.left = min;
						walking.left.left = left;
						walking.left.right = right;
					}
					return true;
				}
			}
			if (walking.value < value) {
				walking = walking.right;
			} else {
				walking = walking.left;
			}
		}
		return false;
	}

	public Node removeMax(Node node) {
		Node walking = root;
		Node maxValue;
		while (walking != null) {
			if (Objects.equals(walking.value, node.value)) {
				maxValue = walking.right;
				return maxValue;
			}
			if (walking.value < node.value) {
				walking = walking.right;
			} else {
				walking = walking.left;
			}
		}
		return null;
	}


	public Node removeMin(Node node) {
		Node walking = root;
		Node minValue = null;
		Node parent = walking;
		while (walking != null) {
			if (Objects.equals(walking.value, node.value)) {
				while (walking.left == null) {
					if (walking.right == null) {
						return null;
					}
					walking = walking.right;
				}
				while (walking.left != null) {
					parent = walking;
					walking = walking.left;
					minValue = walking;
				}
				parent.left = null;
				return minValue;
			}
			if (walking.value < node.value) {
				parent = walking;
				walking = walking.right;
			} else {
				parent = walking;
				walking = walking.left;
			}
		}
		return null;
	}


}
