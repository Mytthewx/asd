package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ListTest {
	@Test
	public void getPersonWithIndexZero() {
		// given
		List<Person> list = new List<>();
		list.add(new Person("Mateusz"));
		int index = 0;

		// when
		Person gotPerson = list.get(0);

		// then
		assertEquals(list.get(0), gotPerson);
	}

	@Test
	public void getPersonWithIndex() {
		// given
		List<Person> list = new List<>();
		list.add(new Person("Mateusz"));
		list.add(new Person("Damian"));
		list.add(new Person("Marek"));
		list.add(new Person("Mariusz"));
		list.add(new Person("Dariusz"));
		int index = 0;

		// when
		Person gotPerson = list.get(index);

		// then
		assertEquals(list.get(index), gotPerson);
	}

	@Test
	public void getObjectsWithNull() {
		// given
		List<Person> list = new List<>();
		list.add(null);

		// when
		Person gotPerson = list.get(0);

		// then
		assertNull(null, gotPerson);
	}

	@Test
	public void removePersonWithIndex() {
		// given
		List<Person> list = new List<>();
		list.add(new Person("Mariusz"));
		list.add(new Person("Marek"));
		int index = 0;

		// when
		list.remove(index);

		// then
		assertEquals(1, list.size());
	}

	@Test
	public void sizeWithSomeObjects() {
		// given
		List<Person> list = new List<>();
		list.add(new Person("Dariusz"));
		list.add(new Person("Arkadiusz"));
		list.add(new Person("Mariusz"));
		list.add(new Person("Marcin"));

		// when
		int result = list.size();

		//then
		assertEquals(4, result);
	}
}
