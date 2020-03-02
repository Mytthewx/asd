package com.company;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

public class Queue<E> {
	private Node last;
	private int counter;

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
		if (walking.getPrev() == null) {
			E flag = walking.getValue();
			walking.setValue(null);
			return flag;
		}
		while (walking.getPrev().getPrev() != null) {
			walking = walking.getPrev();
		}
		E flag = walking.getPrev().getValue();
		walking.setPrev(null);
		return flag;
	}

	public void add(E value) {
		Node node = new Node(value);
		node.setPrev(last);
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
			walking = walking.getPrev();
			walking2 = walking2.getPrev();
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
			walking = walking.getPrev();
		}
		return result;
	}

	public boolean contains(E value) {
		Node walking = last;
		if (size() == 0) {
			return false;
		}
		do {
			if (walking.getValue() == value) {
				return true;
			}
			if (walking.getValue() == null) {
				return false;
			}
			if (walking.getValue().equals(value)) {
				return true;
			}
			walking = walking.getPrev();
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
