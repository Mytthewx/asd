package com.company;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

public class List<E> {
	private Node last;

	@Getter
	@Setter
	@EqualsAndHashCode
	private class Node {
		private Node prev;
		private Node next;
		private E value;

		public Node(E value) {
			this.value = value;
		}


		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	public E get(int i) {
		return null;
	}

	public E remove(int i) {
		return null;
	}

	public E remove(Person person) {
		return null;
	}

	public void add(E value) {
		Node node = new Node(value);
		node.setPrev(last);
		last = node;
	}

	public E set(int i, Person person) {
		return null;
	}

	public int size() {
		return 0;
	}

	public boolean contains(E value) {
		return true;
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
