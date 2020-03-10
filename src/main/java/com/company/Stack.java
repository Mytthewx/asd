package com.company;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

public class Stack<E> {
	private Node top;
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

	public void add(E value) {
		Node node = new Node(value);
		node.setPrev(top);
		top = node;
		counter++;
	}

	public int size() {
		return counter;
	}


	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		Node walking = top;
		while (walking != null) {
			s.append(walking);
			walking = walking.prev;
		}
		return s.toString();
	}
}
