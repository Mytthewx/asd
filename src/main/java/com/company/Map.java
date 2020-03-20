package com.company;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public class Map<K, V> {
	private Node last;
	private int size;

	@Getter
	@Setter
	@EqualsAndHashCode
	private class Node {
		private Node prev;
		private K key;
		private V value;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	public void add(K key, V value) {
		Node node = new Node(key, value);
		node.prev = last;
		last = node;
		size++;
	}

	public V get(K key) {
		Node walking = last;
		if (size == 0) {
			return null;
		}
		while (walking != null) {
			if (Objects.equals(walking.key, key)) {
				return walking.value;
			}
			walking = walking.prev;
		}
		return null;
	}

	public void remove(K key) {
		Node walking = last;
		while (walking != null) {
			if (Objects.equals(walking.key, key)) {
				walking.key = null;
				walking.value = null;
			}
			walking = walking.prev;
		}
	}

	public boolean containsKey(K key) {
		Node walking = last;
		if (size() == 0) {
			return false;
		}
		do {
			if (Objects.equals(walking.key, key)) {
				return true;
			}
			walking = walking.getPrev();
		} while (walking != null);
		return false;
	}

	public boolean containsValue(V value) {
		Node walking = last;
		if (size() == 0) {
			return false;
		}
		do {
			if (Objects.equals(walking.value, value)) {
				return true;
			}
			walking = walking.getPrev();
		} while (walking != null);
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Map<K, V> map = (Map<K, V>) o;
		if (size() != map.size()) {
			return false;
		}
		Node walking = last;
		Node walking2 = map.last;
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

	public int size() {
		return size;
	}


}
