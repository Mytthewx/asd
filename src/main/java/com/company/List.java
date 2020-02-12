package com.company;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

public class List<E> {
	private Node last;
	private int index;

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

	public E get(int i) {
	}

	public E remove(int i) {
		return null;
	}

	public E remove(Person person) {
		return null;
	}

	public E add(Person person) {
		return null;
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
