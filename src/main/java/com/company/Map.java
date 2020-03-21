package com.company;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Map<K, V> {
	private Node<K, V> last;
	private int size;

	@Getter
	@Setter
	@EqualsAndHashCode
	@ToString
	protected class Node<K, V> {
		private Node<K, V> prev;
		private K key;
		private V value;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	public void add(K key, V value) {
		Node<K, V> node = new Node<>(key, value);
		node.prev = last;
		last = node;
		size++;
	}

	public V get(K key) {
		Node<K, V> walking = last;
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

	public boolean remove(K key) {
		Node<K, V> walking = last;
		while (walking != null) {
			if (Objects.equals(walking.key, key)) {
				walking.key = null;
				walking.value = null;
				size--;
				return true;
			}
			walking = walking.prev;
		}
		return false;
	}

	public boolean containsKey(K key) {
		Node<K, V> walking = last;
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
		Node<K, V> walking = last;
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

	Set<K> keySet() {
		Node<K, V> walking = last;
		Set<K> keys = new HashSet<>();
		do {
			keys.add(walking.key);
			walking = walking.prev;
		} while (walking != null);
		return keys;
	}

	Set<V> valueSet() {
		Node<K, V> walking = last;
		Set<V> values = new LinkedHashSet<>();
		do {
			values.add(walking.value);
			walking = walking.prev;
		} while (walking != null);
		return values;
	}

	Set<Node<K, V>> nodeSet() {
		Node<K, V> walking = last;
		Set<Node<K, V>> nodes = new LinkedHashSet<>();
		do {
			nodes.add(walking);
			walking = walking.prev;
		} while (walking != null);
		return nodes;
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
		Node<K, V> walking = last;
		Node<K, V> walking2 = map.last;
		while (walking != null) {
			if (!walking.equals(walking2)) {
				return false;
			}
			walking = walking.getPrev();
			walking2 = walking2.getPrev();
		}
		return true;
	}

	public int size() {
		return size;
	}

	@Override
	public int hashCode() {
		Node<K, V> walking = last;
		int prime = 3;
		int result = 1;
		while (walking != null) {
			result = prime * result + (walking.hashCode());
			walking = walking.getPrev();
		}
		return result;
	}
}
