package com.company;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QueueTest {
	@Test
	public void getCorrectPersonAfterAdd() {
		// given
		Queue queue = new Queue();
		Person person = new Person("Maciej");
		queue.add(person);
		// when
		Person gotPerson = queue.get();
		// then
		assertEquals(person, gotPerson);
	}

	@Test
	public void containsNullAfterAddingNull() {
		// given
		Queue queue = new Queue();
		queue.add(null);
		// when
		boolean result = queue.contains(null);
		// then
		assertTrue(result);
	}

	@Test
	public void containsPersonAfterAddingNull() {
		// given
		Person person = new Person("Andrzej");
		Queue queue = new Queue();
		queue.add(null);
		// when
		boolean result = queue.contains(person);
		// then
		assertFalse(result);
	}

	@Test
	public void containsPersonAfterAddPerson() {
		// given
		Queue queue = new Queue();
		Person person = new Person("Marek");
		queue.add(person);
		// when
		boolean result = queue.contains(person);
		// then
		assertTrue(result);
	}

	@Test
	public void containsNullAfterAddPerson() {
		// given
		Queue queue = new Queue();
		Person person = new Person("Dariusz");
		queue.add(person);
		// when
		boolean result = queue.contains(null);
		// then
		assertFalse(result);
	}

	@Test
	public void getSizeOfEmptyQueue() {
		// given
		Queue queue = new Queue();
		// when
		int result = queue.size();
		// then
		assertEquals(0, result);
	}

	@Test
	public void getSizeOfQueueWithNull() {
		// given
		Queue queue = new Queue();
		queue.add(null);
		// when
		int result = queue.size();
		// then
		assertEquals(1, result);
	}

	@Test
	public void getSizeOfQueueWithFiveObjects() {
		// given
		Queue queue = new Queue();
		queue.add(new Person("Mateusz"));
		queue.add(new Person("Dawid"));
		queue.add(new Person("Dariusz"));
		queue.add(new Person("Mariusz"));
		queue.add(new Person("Marek"));
		// when
		int result = queue.size();
		// then
		assertEquals(5, result);
	}

	@Test
	public void equalMethodTest() {
		// given
		Queue queue1 = new Queue();
		Queue queue2 = new Queue();
		Person person = new Person("Dawid");
		queue1.add(person);
		queue2.add(person);
		// when
		boolean result = queue1.equals(queue2);
		// then
		assertTrue(result);
	}
}
