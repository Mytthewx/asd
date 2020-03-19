package com.company;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MapTest {
	@Test
	public void addTest() {
		// given
		Map<Person, Integer> map = new Map<>();

		// when
		map.add(new Person("Mateusz"), 23);

		// then
		assertEquals(1, map.size());
		assertTrue(map.containsValue(23));
	}

	@Test
	public void addObjectAndNull() {
		// given
		Map<Person, Integer> map = new Map<>();

		// when
		map.add(new Person("Mateusz"), 23);
		map.add(null, 24);

		// then
		assertEquals(2, map.size());
		assertTrue(map.containsValue(23));
		assertTrue(map.containsValue(24));
		assertTrue(map.containsKey(null));
		assertTrue(map.containsKey(new Person("Mateusz")));
		assertFalse(map.containsKey(new Person("Andrzej")));
	}

	@Test
	public void getObjectAfterAddSomeObjects() {
		// given
		Map<Person, Integer> map = new Map<>();
		Person person = new Person("Mateusz");
		Person person2 = new Person("Andrzej");
		Person person3 = new Person("Damian");
		map.add(person, 23);
		map.add(person2, 25);
		map.add(person3, 30);

		// when
		int result = map.get(person2);

		// then
		assertEquals(3, map.size());
		assertEquals(25, result);
	}

	@Test
	public void equalsTest() {
		// given
		Map<Person, Integer> map = new Map<>();
		Map<Person, Integer> map2 = new Map<>();
		Person person1 = new Person("Mateusz");
		Person person2 = new Person("Andrzej");
		Person person3 = new Person("Damian");
		map.add(person1, 23);
		map.add(person2, 25);
		map.add(person3, 30);
		map2.add(person1, 23);
		map2.add(person2, 25);
		map2.add(person3, 30);

		// when
		boolean result = map.equals(map2);

		// then
		assertEquals(3, map.size());
		assertEquals(3, map2.size());
		assertTrue(result);
		assertTrue(map.containsKey(person1));
		assertTrue(map.containsKey(person2));
		assertTrue(map.containsKey(person3));
		assertTrue(map.containsValue(23));
		assertTrue(map.containsValue(30));
		assertTrue(map.containsValue(25));
	}

	@Test
	public void hashCodeTest() {
		// given
		HashSet<Map<Person, Integer>> hashSet = new HashSet<>();
		Map<Person, Integer> map = new Map<>();
		Map<Person, Integer> map2 = new Map<>();
		Map<Person, Integer> map3 = new Map<>();
		map.add(new Person("Maciej"), 22);
		map2.add(new Person("Dariusz"), 23);
		map3.add(new Person("Pawel"), 24);
		hashSet.add(map);
		hashSet.add(map2);
		hashSet.add(map3);

		// when
		int result = hashSet.size();

		// then
		assertEquals(3, result);
	}

}
