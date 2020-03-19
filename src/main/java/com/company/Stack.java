package com.company;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.NoSuchElementException;
import java.util.Objects;

public class Stack<E> {
	private Node top;
	private int size;

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

	public void put(E value) {
		Node node = new Node(value);
		node.setPrev(top);
		top = node;
		size++;
	}

	public E pop() {
		if (size == 0) {
			throw new NoSuchElementException("Can't find an element.");
		}
		E flag = top.getValue();
		top = top.prev;
		size--;
		return flag;
	}

	public E peek() {
		if (size == 0) {
			throw new NoSuchElementException("Can't find an element.");
		}
		return top.getValue();
	}

	public boolean contains(E value) {
		Node walking = top;
		int counter = size - 1;
		if (size() <= 0) {
			return false;
		}
		while (counter >= 0) {
			if (Objects.equals(walking.value, value)) {
				return true;
			}
			walking = walking.prev;
			counter--;
		}
		return false;
	}

	public int size() {
		return size;
	}

	public void clear() {
		top = null;
		size = 0;
	}

	@Override
	public int hashCode() {
		Node walking = top;
		int prime = 3;
		int result = 1;
		while (walking != null) {
			result = prime * result + (walking.hashCode());
			walking = walking.getPrev();
		}
		return result;
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
