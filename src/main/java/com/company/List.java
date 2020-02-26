package com.company;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

public class List<E> {
	private Node last;
	private int size;

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
		Node walking = last;
		int counter = size - 1;
		if (i >= size) {
			throw new IndexOutOfBoundsException("index: " + i + ", size: " + size);
		}
		while (counter != i) {
			counter--;
			walking = walking.getPrev();
		}
		E flag = walking.getValue();
		return flag;
	}

	public E remove(int i) {
		Node walking = last;
		int counter = size - 1;
		while (counter != i) {
			counter--;
			walking = walking.getPrev();
		}
		walking.setValue(null);
		size--;
		return null;
	}

	public E remove(Person person) {
		size--;
		return null;
	}

	public void add(E value) {
		Node node = new Node(value);
		node.setPrev(last);
		last = node;
		size++;
	}

	public E set(int i, Person person) {
		return null;
	}

	public int size() {
		return size;
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
