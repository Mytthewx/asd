package com.company;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class StackTest {
	@Test
	public void getPersonFromTopAfterAddSomeObjects() {
		// given
		Stack<Person> stack = new Stack<>();
		Person person = new Person("Mateusz");
		Person person2 = new Person("Andrzej");
		Person person3 = new Person("Marcin");
		stack.put(person);
		stack.put(person2);
		stack.put(person3);

		// when
		Person result = stack.pop();

		// then
		assertEquals(person3, result);
		assertEquals(2, stack.size());
		assertFalse(stack.contains(person3));
	}

	@Test
	public void getPersonFromTopAfterAddingObjectAndNull() {
		// given
		Stack<Person> stack = new Stack<>();
		Person person = new Person("Mateusz");
		Person person2 = new Person("Andrzej");
		stack.put(person);
		stack.put(null);
		stack.put(person2);

		// when
		Person result = stack.pop();

		// then
		assertEquals(person2, result);
		assertEquals(2, stack.size());
		assertFalse(stack.contains(person2));
		assertTrue(stack.contains(person));
	}

	@Test
	public void getPersonFromTopAfterAddingOneObject() {
		// given
		Stack<Person> stack = new Stack<>();
		Person person = new Person("Mateusz");
		stack.put(person);

		// when
		Person result = stack.pop();

		// then
		assertEquals(person, result);
		assertEquals(0, stack.size());
		assertFalse(stack.contains(person));
	}

	@Test
	public void getPersonFromTopAfterAddingObjectThenNullOnTop() {
		// given
		Stack<Person> stack = new Stack<>();
		Person person = new Person("Mateusz");
		Person person2 = new Person("Andrzej");
		stack.put(person);
		stack.put(person2);
		stack.put(null);

		// when
		Person result = stack.pop();

		// then
		assertNull(result);
		assertEquals(2, stack.size());
		assertTrue(stack.contains(person2));
		assertTrue(stack.contains(person));
	}

	@Test
	public void getPersonAfterAddingNull() {
		// given
		Stack<Person> stack = new Stack<>();
		Person person = new Person("Mateusz");
		stack.put(null);

		// when
		Person result = stack.pop();

		// then
		assertNull(result);
		assertEquals(0, stack.size());
		assertFalse(stack.contains(person));
	}

	@Test
	public void getPersonAfterAddingPersonAndNullThenRemoveTopObject() {
		// given
		Stack<Person> stack = new Stack<>();
		Person person = new Person("Mateusz");
		Person person2 = new Person("Damian");
		stack.put(person);
		stack.put(null);

		// when
		Person result = stack.pop();
		stack.put(person2);

		// then
		assertNull(result);
		assertEquals(2, stack.size());
		assertTrue(stack.contains(person));
		assertTrue(stack.contains(person2));
	}

	@Test
	public void getThreeObjectsAfterAddingThreeObjects() {
		// given
		Stack<Person> stack = new Stack<>();
		Person person1 = new Person("Mateusz");
		Person person2 = new Person("Damian");
		Person person3 = new Person("Damian");
		stack.put(person1);
		stack.put(person2);
		stack.put(person3);

		// when
		Person result1 = stack.pop();
		Person result2 = stack.pop();
		Person result3 = stack.pop();

		// then
		assertEquals(person3, result1);
		assertEquals(person2, result2);
		assertEquals(person1, result3);
		assertEquals(0, stack.size());
		assertFalse(stack.contains(person1));
		assertFalse(stack.contains(person2));
		assertFalse(stack.contains(person3));
	}

	@Test
	public void getAllObjectsAfterAddingObjectsMixedWithNull() {
		// given
		Stack<Person> stack = new Stack<>();
		Person person1 = new Person("Mateusz");
		Person person2 = new Person("Damian");
		stack.put(person1);
		stack.put(null);

		// when
		Person result = stack.pop();
		stack.put(person2);
		Person result2 = stack.pop();
		Person result3 = stack.pop();

		// then
		assertNull(result);
		assertEquals(person2, result2);
		assertEquals(person1, result3);
		assertEquals(0, stack.size());
		assertFalse(stack.contains(person1));
		assertFalse(stack.contains(person2));
	}

	@Test(expected = NoSuchElementException.class)
	public void getTwoObjectsAfterAddingOneObject() {
		// given
		Stack<Person> stack = new Stack<>();
		Person person = new Person("Mateusz");
		stack.put(person);

		// when
		stack.pop();
		stack.pop();

		// then
		assertEquals(0, stack.size());
	}

	@Test(expected = NoSuchElementException.class)
	public void getNonExistentObjectFromStack() {
		// given
		Stack<Person> stack = new Stack<>();
		Person person = new Person("Mateusz");
		stack.put(null);
		stack.put(person);

		// when
		Person result = stack.pop();
		stack.pop();
		stack.pop();

		// then
		assertEquals(person, result);
		assertEquals(0, stack.size());
		assertFalse(stack.contains(person));
	}

	@Test
	public void sizeAfterAddingThreeObjects() {
		// given
		Stack<Person> stack = new Stack<>();
		stack.put(new Person("Mateusz"));
		stack.put(new Person("Damian"));
		stack.put(new Person("Andrzej"));

		// when
		int result = stack.size();

		// then
		assertEquals(3, result);
	}

	@Test
	public void sizeAfterAddingThreeObjectsAndAddingNull() {
		// given
		Stack<Person> stack = new Stack<>();
		stack.put(new Person("Mateusz"));
		stack.put(new Person("Damian"));
		stack.put(new Person("Andrzej"));
		stack.put(null);

		// when
		int result = stack.size();

		// then
		assertEquals(4, result);
	}

	@Test
	public void sizeAfterAddingNull() {
		// given
		Stack<Person> stack = new Stack<>();
		stack.put(null);

		// when
		int result = stack.size();

		// then
		assertEquals(1, result);
	}

	@Test
	public void sizeAfterAddingNullAndSomeObjects() {
		// given
		Stack<Person> stack = new Stack<>();
		stack.put(null);
		stack.put(new Person("Mateusz"));
		stack.put(new Person("Damian"));

		// when
		int result = stack.size();

		// then
		assertEquals(3, result);
	}

	@Test
	public void sizeAfterAddingNullAndAddingSomeObjectThenRemoveSomeObjects() {
		// given
		Stack<Person> stack = new Stack<>();
		Person person = new Person("Mateusz");
		Person person2 = new Person("Damian");
		stack.put(null);
		stack.put(person);
		stack.put(person2);
		stack.pop();

		// when
		int result = stack.size();

		// then
		assertEquals(2, result);
		assertFalse(stack.contains(person2));
		assertTrue(stack.contains(person));
		assertTrue(stack.contains(null));
	}

	@Test
	public void clearAfterAddSomeObjectsToStack() {
		// given
		Stack<Person> stack = new Stack<>();
		stack.put(new Person("Mateusz"));
		stack.put(new Person("Andrzej"));
		stack.put(new Person("Marcin"));

		// when
		stack.clear();

		// then
		assertEquals(0, stack.size());
	}

	@Test
	public void clearAfterAddingSomeObjectsAddingNullToStack() {
		// given
		Stack<Person> stack = new Stack<>();
		Person person = new Person("Mateusz");
		stack.put(person);
		stack.put(new Person("Andrzej"));
		stack.put(new Person("Marcin"));
		stack.put(null);

		// when
		stack.clear();

		// then
		assertEquals(0, stack.size());
		assertFalse(stack.contains(person));
	}

	@Test
	public void clearAfterAddingNullToStack() {
		// given
		Stack<Person> stack = new Stack<>();
		Person person = new Person("Mateusz");
		stack.put(null);

		// when
		stack.clear();

		// then
		assertEquals(0, stack.size());
		assertFalse(stack.contains(person));
	}

	@Test
	public void clearAfterAddingNullAndThenObjectsToStack() {
		// given
		Stack<Person> stack = new Stack<>();
		Person person = new Person("Mateusz");
		stack.put(null);
		stack.put(person);

		// when
		stack.clear();

		// then
		assertEquals(0, stack.size());
		assertFalse(stack.contains(person));
	}
}
