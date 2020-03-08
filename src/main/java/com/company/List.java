package com.company;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

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
		return walking.getValue();
	}

	public E remove(int i) {
		Node walking = last;
		int counter = size - 1;
		while (counter != i) {
			counter--;
			walking = walking.getPrev();
		}
		E flag = walking.getValue();
		walking.setValue(null);
		size--;
		return flag;
	}

	public int remove(E value) {
		Node walking = last;
		int counter = size - 1;
		if (size < 0) {
			return counter;
		}
		while (counter >= 0) {
			if (walking.value == value) {
				walking.value = null;
				return counter;
			}
			if (walking.value.equals(value)) {
				walking.value = null;
				size--;
				counter--;
				return counter;
			}
			if (walking.prev == null) {
				return -1;
			}
			if (walking.prev.value == null) {
				walking.prev = walking.prev.prev;
				size--;
				return counter;
			}
			if (walking.prev.value.equals(value)) {
				walking.prev.value = null;
				size--;
				return counter;
			}
			walking = walking.prev;
			counter--;
		}
		return -1;
	}

	public void add(E value) {
		Node node = new Node(value);
		node.setPrev(last);
		last = node;
		size++;
	}

	public void set(int i, E value) {
		Node walking = last;
		int counter = size - 1;
		if (i > size) {
			throw new IndexOutOfBoundsException("index: " + i + ", size: " + size);
		}
		if (i < 0) {
			throw new IndexOutOfBoundsException("index: " + i + ", size: " + size);
		}
		while (counter != i) {
			counter--;
			walking = walking.getPrev();
		}
		walking.setValue(value);
	}

	public boolean contains(E value) {
		Node walking = last;
		int counter = size - 1;
		if (size() == 0) {
			return false;
		}
		do {
			if (walking.getValue() == value) {
				return true;
			}
			if (Objects.equals(walking.getValue(), value)) {
				return true;
			}
			walking = walking.getPrev();
			counter--;
		} while (walking != null);
		return false;
	}

	public int size() {
		return size;
	}

	public void clear() {
		last = null;
		size = 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		List<E> list = (List<E>) o;
		if (size() != list.size()) {
			return false;
		}
		Node walking = last;
		Node walking2 = list.last;
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
