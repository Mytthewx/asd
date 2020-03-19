package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapTest {
	@Test
	public void addTest() {
		// given
		Map<Person, Integer> map = new Map<>();

		// when
		map.add(new Person("Mateusz"), 23);

		// then
		assertEquals(1, map.size());
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
}
