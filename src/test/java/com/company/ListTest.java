package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ListTest {
	@Test
	public void getPersonWithIndexZero() {
		// given
		List<Person> list = new List<>();
		Person person = new Person("Daniel");
		list.add(new Person("Mateusz"));

		// when
		Person gotPerson = list.get(0);

		// then
		assertEquals(person, gotPerson);
	}

	@Test
	public void getPersonWithIndex() {
		// given
		List<Person> list = new List<>();
		Person person = new Person("Mateusz");
		list.add(new Person("Damian"));
		list.add(person);
		list.add(new Person("Marek"));
		list.add(new Person("Mariusz"));
		list.add(new Person("Dariusz"));

		// when
		Person gotPerson = list.get(1);

		// then
		assertEquals(person, gotPerson);
	}

	@Test
	public void getObjectsWithNull() {
		// given
		List<Person> list = new List<>();
		list.add(null);

		// when
		Person gotPerson = list.get(0);

		// then
		assertNull(gotPerson);
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
	public void removePersonWithPersonArg() {
		// given
		List<Person> list = new List<>();
		Person person1 = new Person("Mateusz");
		Person person2 = new Person("Andrzej");
		list.add(person1);
		list.add(person2);

		// when
		list.remove(person1);

		// then
		assertTrue(list.contains(person2));
		assertFalse(list.contains(person1));
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

	@Test
	public void sizeWithNull() {
		// given
		List<Person> list = new List<>();
		list.add(null);

		// when
		int result = list.size();

		// then
		assertEquals(1, result);
	}

	@Test
	public void containsNullAfterAddingPerson() {
		// given
		List<Person> list = new List<>();
		list.add(new Person("Przemyslaw"));

		// when
		boolean result = list.contains(null);

		// then
		assertFalse(result);
	}

	@Test
	public void containsPersonAfterAddingAnotherPerson() {
		// given
		List<Person> list = new List<>();
		Person person = new Person("Daniel");
		Person person1 = new Person("Mariusz");
		list.add(person);

		// when
		boolean result = list.contains(person1);

		// then
		assertFalse(result);
	}

	@Test
	public void containsPersonAfterAddingPerson() {
		// given
		List<Person> list = new List<>();
		Person person = new Person("Marek");
		list.add(person);

		// when
		boolean result = list.contains(person);

		// then
		assertTrue(result);
	}

	@Test
	public void containsPersonAfterAddingNull() {
		// given
		List<Person> list = new List<>();
		Person person = new Person("Mariusz");
		list.add(null);

		// when
		boolean result = list.contains(person);

		// then
		assertFalse(result);
	}

	@Test
	public void containsNullAfterAddingNull() {
		// given
		List<Person> list = new List<>();
		list.add(null);

		// when
		boolean result = list.contains(null);

		// then
		assertTrue(result);
	}

	@Test
	public void containsNullAndPersonAfterAddingNullAndPerson() {
		List<Person> list = new List<>();
		Person person = new Person("Damian");
		list.add(null);
		list.add(person);
		list.add(null);
		list.add(new Person("Mateusz"));

		// when
		boolean result = list.contains(null);
		boolean result2 = list.contains(person);

		// then
		assertTrue(result);
		assertTrue(result2);
	}

	@Test
	public void containsNullAndPersonWithEmptyList() {
		List<Person> list = new List<>();
		Person person = new Person("Matuesz");

		// when
		boolean result = list.contains(null);
		boolean result2 = list.contains(person);

		// then
		assertFalse(result);
		assertFalse(result2);
	}

	@Test
	public void setPerson() {
		// given
		List<Person> list = new List<>();
		Person person = new Person("Maciej");
		Person person1 = new Person("Mateusz");
		Person person2 = new Person("Dawid");
		list.add(person);
		list.add(person1);
		list.add(person2);

		// when
		list.set(2, person);

		// then
		assertEquals(list.get(2), person);
		assertEquals(list.get(0), person);
	}

	@Test
	public void setNull() {
		// given
		List<Person> list = new List<>();
		list.add(new Person("Maciej"));
		list.add(new Person("Darek"));
		list.add(new Person("Marek"));

		// when
		list.set(1, null);

		// then
		assertEquals(list.get(1), null);
	}

}
