package com.company;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
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
	public void addObjectAndAddNull() {
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
	public void getNonExistObject() {
		// given
		Map<Person, Integer> map = new Map<>();
		Person person = new Person("Mateusz");

		// when
		Integer result = map.get(person);

		// then
		assertNull(result);
	}

	@Test
	public void getNullObject() {
		// given
		Map<Person, Integer> map = new Map<>();
		map.add(null, null);

		// when
		Integer result = map.get(null);

		// then
		assertNull(result);
		assertEquals(1, map.size());
		assertTrue(map.containsKey(null));
		assertTrue(map.containsValue(null));
	}

	@Test
	public void getObjectAfterRemoveSomeObject() {
		// given
		Map<Person, Integer> map = new Map<>();
		Person person1 = new Person("Mateusz");
		Person person2 = new Person("Andrzej");
		Person person3 = new Person("Damian");
		map.add(person1, 23);
		map.add(person2, 25);
		map.add(person3, 7);
		map.remove(person2);

		// when
		int result = map.get(person1);

		// then
		assertEquals(2, map.size());
		assertEquals(23, result);
		assertTrue(map.containsKey(person1));
		assertTrue(map.containsKey(person3));
		assertFalse(map.containsKey(person2));
		assertTrue(map.containsValue(23));
		assertTrue(map.containsValue(7));
		assertFalse(map.containsValue(25));
	}

	@Test
	public void getObjectThatIsNotInTheMap() {
		// given
		Map<Person, Integer> map = new Map<>();
		Person person1 = new Person("Mateusz");
		Person person2 = new Person("Damian");
		map.add(person1, 23);

		// when
		Integer result = map.get(person2);

		// then
		assertNull(result);
		assertEquals(1, map.size());
		assertTrue(map.containsKey(person1));
		assertTrue(map.containsValue(23));
		assertFalse(map.containsKey(person2));
		assertFalse(map.containsValue(25));
	}

	@Test
	public void removeObjectFromMap() {
		// given
		Map<Person, Integer> map = new Map<>();
		Person person1 = new Person("Mateusz");
		Person person2 = new Person("Damian");
		map.add(person1, 23);
		map.add(person2, 24);

		// when
		boolean result = map.remove(person1);

		// then
		assertTrue(result);
		assertTrue(map.containsValue(24));
		assertTrue(map.containsKey(person2));
		assertFalse(map.containsValue(23));
		assertFalse(map.containsKey(person1));
	}

	@Test
	public void removeObjectWithTheSameValueFromMap() {
		// given
		Map<Person, Integer> map = new Map<>();
		Person person1 = new Person("Mateusz");
		Person person2 = new Person("Damian");
		map.add(person1, 23);

		// when
		boolean result = map.remove(person2);

		// then
		assertFalse(result);
		assertEquals(1, map.size());
		assertTrue(map.containsKey(person1));
		assertTrue(map.containsValue(23));
		assertFalse(map.containsKey(person2));
		assertFalse(map.containsValue(25));
	}

	@Test
	public void removeObjectThatIsNotInMap() {
		// given
		Map<Person, Integer> map = new Map<>();
		Person person1 = new Person("Mateusz");
		Person person2 = new Person("Damian");
		map.add(person1, 24);
		map.add(person2, 24);

		// when
		boolean result = map.remove(person1);

		// then
		assertTrue(result);
		assertTrue(map.containsValue(24));
		assertTrue(map.containsKey(person2));
		assertFalse(map.containsValue(23));
		assertFalse(map.containsKey(person1));
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
	public void containsKeyTestWithSizeZero() {
		// given
		Map<Person, Integer> map = new Map<>();
		Person person1 = new Person("Mateusz");

		// when
		boolean result = map.containsKey(person1);

		// then
		assertFalse(result);
		assertFalse(map.containsValue(23));
		assertEquals(0, map.size());
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

	@Test
	public void equalsMapWithTheSameObjects() {
		// given
		Map<Person, Integer> map = new Map<>();
		Map<Person, Integer> map2 = new Map<>();
		Person person1 = new Person("Mateusz");
		map.add(person1, 23);
		map2.add(person1, 23);

		// when
		boolean result = map.equals(map2);

		// then
		assertTrue(result);
		assertTrue(map.containsKey(person1));
		assertTrue(map2.containsKey(person1));
		assertTrue(map.containsValue(23));
		assertTrue(map2.containsValue(23));
	}

	@Test
	public void equalsMapWithDifferentObjectAndTheSameSize() {
		// given
		Map<Person, Integer> map = new Map<>();
		Map<Person, Integer> map2 = new Map<>();
		Person person1 = new Person("Mateusz");
		Person person2 = new Person("Andrzej");
		map.add(person1, 23);
		map2.add(person2, 25);

		// when
		boolean result = map.equals(map2);
		boolean result2 = map2.equals(map);

		// then
		assertFalse(result);
		assertFalse(result2);
		assertTrue(map.containsKey(person1));
		assertFalse(map2.containsKey(person1));
		assertTrue(map.containsValue(23));
		assertFalse(map2.containsValue(23));
		assertTrue(map2.containsValue(25));
		assertFalse(map2.containsValue(23));
	}

	@Test
	public void equalsMapWithDifferentSize() {
		// given
		Map<Person, Integer> map = new Map<>();
		Map<Person, Integer> map2 = new Map<>();
		Person person1 = new Person("Mateusz");
		Person person2 = new Person("Andrzej");
		Person person3 = new Person("Damian");
		map.add(person1, 23);
		map2.add(person2, 25);
		map2.add(person3, 26);

		// when
		boolean result = map.equals(map2);
		boolean result2 = map2.equals(map);

		// then
		assertFalse(result);
		assertFalse(result2);
		assertTrue(map.containsKey(person1));
		assertFalse(map2.containsKey(person1));
		assertTrue(map.containsValue(23));
		assertFalse(map2.containsValue(23));
		assertTrue(map2.containsValue(25));
		assertFalse(map2.containsValue(23));
		assertFalse(map.containsValue(26));
		assertTrue(map2.containsValue(26));
	}

	@Test
	public void equalsTwoEmptyMaps() {
		// given
		Map<Person, Integer> map = new Map<>();
		Map<Person, Integer> map2 = new Map<>();

		// when
		boolean result = map.equals(map2);
		boolean result2 = map2.equals(map);

		// then
		assertTrue(result);
		assertTrue(result2);
	}

	@Test
	public void equalsItSelfMap() {
		// given
		Map<Person, Integer> map = new Map<>();

		// when
		boolean result = map.equals(map);

		// then
		assertTrue(result);
	}

	@Test
	public void equalsMapWithNullToMapWithObject() {
		// given
		Map<Person, Integer> map = new Map<>();
		Map<Person, Integer> map2 = new Map<>();
		map.add(new Person("Mateusz"), 23);

		// when
		boolean result = map.equals(map2);

		// then
		assertFalse(result);
		assertFalse(map2.containsKey(new Person("Mateusz")));
		assertTrue(map.containsValue(23));
		assertFalse(map2.containsValue(23));
		assertFalse(map2.containsKey(new Person("Mateusz")));
	}

	@Test
	public void keySetTest() {
		// given
		Map<Person, Integer> map = new Map<>();
		Person person = new Person("Mateusz");
		Person person2 = new Person("Marcin");
		Person person3 = new Person("Andrzej");
		map.add(person, 23);
		map.add(person2, 25);
		map.add(person3, 22);

		// when
		Set<Person> result = map.keySet();

		// then
		assertTrue(result.contains(person));
		assertTrue(result.contains(person2));
		assertTrue(result.contains(person3));
		assertEquals(3, result.size());
		assertEquals(3, map.size());
	}

	@Test
	public void valueSetTest() {
		// given
		Map<Person, Integer> map = new Map<>();
		Person person = new Person("Mateusz");
		Person person2 = new Person("Marcin");
		Person person3 = new Person("Andrzej");
		map.add(person, 23);
		map.add(person2, 25);
		map.add(person3, 22);

		// when
		Set<Integer> result = map.valueSet();

		// then
		assertTrue(result.contains(23));
		assertTrue(result.contains(25));
		assertTrue(result.contains(22));
		assertEquals(3, result.size());
		assertEquals(3, map.size());
	}

//	@Test
//	public void nodeSetTest() {
//		// given
//		Map<Person, Integer> map = new Map<>();
//		Person person = new Person("Mateusz");
//		Person person2 = new Person("Marcin");
//		Person person3 = new Person("Andrzej");
//		map.add(person, 23);
//		map.add(person2, 25);
//		map.add(person3, 22);
//
//		// when
//
//		// then
//	}
}
