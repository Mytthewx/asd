package eu.mytthew;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@ToString
public class Map<K, V> {
	private Node last;
	private int size;

	@Getter
	@EqualsAndHashCode
	@ToString
	protected class Node {
		private Node prev;
		private Entry<K, V> entry;

		public Node(K key, V value) {
			entry = new Entry<>(key, value);
		}
	}


	@Getter
	@EqualsAndHashCode
	@ToString
	public static class Entry<K, V> {
		private K key;
		private V value;

		public Entry(K key, V value) {
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
			if (Objects.equals(walking.entry.key, key)) {
				return walking.entry.value;
			}
			walking = walking.prev;
		}
		return null;
	}

	public boolean remove(K key) {
		Node walking = last;
		while (walking != null) {
			if (Objects.equals(walking.entry.key, key)) {
				walking.entry.key = null;
				walking.entry.value = null;
				size--;
				return true;
			}
			walking = walking.prev;
		}
		return false;
	}

	public boolean containsKey(K key) {
		Node walking = last;
		if (size() == 0) {
			return false;
		}
		do {
			if (Objects.equals(walking.entry.key, key)) {
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
			if (Objects.equals(walking.entry.value, value)) {
				return true;
			}
			walking = walking.getPrev();
		} while (walking != null);
		return false;
	}

	Set<K> keySet() {
		Node walking = last;
		Set<K> keys = new HashSet<>();
		do {
			keys.add(walking.entry.key);
			walking = walking.prev;
		} while (walking != null);
		return keys;
	}

	Set<V> valueSet() {
		Node walking = last;
		Set<V> values = new HashSet<>();
		do {
			values.add(walking.entry.value);
			walking = walking.prev;
		} while (walking != null);
		return values;
	}

	Set<Entry<K, V>> entrySet() {
		Node walking = last;
		Set<Entry<K, V>> entries = new HashSet<>();
		do {
			entries.add(walking.entry);
			walking = walking.prev;
		} while (walking != null);
		return entries;
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

	public int size() {
		return size;
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
