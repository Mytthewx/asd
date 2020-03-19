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
		while (walking != null) {
			if (Objects.equals(walking.key, key)) {
				return walking.value;
			}
			walking = walking.prev;
		}
		return null;
	}

	public int size() {
		return size;
	}


}
