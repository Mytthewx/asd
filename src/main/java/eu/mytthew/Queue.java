package eu.mytthew;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

public class Queue<E> {
	private Node last;
	private int counter;

	@Data
	@Getter
	@Setter
	@EqualsAndHashCode
	private class Node {
		private Node prev;
		private E value;

		public Node(E value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	public E get() {
		Node walking = last;
		counter--;
		if (walking.prev == null) {
			E flag = walking.value;
			walking.value = null;
			return flag;
		}
		while (walking.prev.prev != null) {
			walking = walking.prev;
		}
		E flag = walking.prev.value;
		walking.prev = null;
		return flag;
	}

	public void add(E value) {
		Node node = new Node(value);
		node.prev = last;
		last = node;
		counter++;
	}

	public int size() {
		return counter;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Queue<E> queue = (Queue<E>) o;
		if (size() != queue.size()) {
			return false;
		}
		Node walking = last;
		Node walking2 = queue.last;
		while (walking != null) {
			if (!walking.equals(walking2)) {
				return false;
			}
			walking = walking.prev;
			walking2 = walking2.prev;
		}
		return true;
	}

	@Override
	public int hashCode() {
		Node walking = last;
		int prime = 3;
		int result = 1;
		while (walking != null) {
			result = prime * result + (walking.hashCode());
			walking = walking.prev;
		}
		return result;
	}

	public boolean contains(E value) {
		Node walking = last;
		if (size() == 0) {
			return false;
		}
		do {
			if (walking.value == value) {
				return true;
			}
			if (walking.value == null) {
				return false;
			}
			if (walking.value.equals(value)) {
				return true;
			}
			walking = walking.prev;
		} while (walking != null);
		return false;
	}

	public void clear() {
		last = null;
		counter = 0;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		Node walking = last;
		while (walking != null) {
			s.append(walking);
			walking = walking.prev;
		}
		return s.toString();
	}
}
