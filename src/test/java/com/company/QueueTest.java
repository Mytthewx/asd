package com.company;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QueueTest {
	@Test
	public void getCorrectPersonAfterAdd() {
		// given
		Queue<Person> queue = new Queue();
		Person person = new Person("Maciej");
		queue.add(person);

		// when
		Person gotPerson = queue.get();

		// then
		assertEquals(person, gotPerson);
	}

	@Test
	public void getCorrectPersonAfterAddFewObjects() {
		// given
		Queue<Person> queue = new Queue();
		Person person1 = new Person("Maciek");
		Person person2 = new Person("Mateusz");
		Person person3 = new Person("Dawid");
		Person person4 = new Person("Pawel");
		queue.add(person1);
		queue.add(person2);
		queue.add(person3);
		queue.add(person4);

		// when
		Person gotPerson = queue.get();
		Person gotPerson2 = queue.get();
		Person gotPerson3 = queue.get();
		Person gotPerson4 = queue.get();

		// then
		assertEquals(person1, gotPerson);
		assertEquals(person2, gotPerson2);
		assertEquals(person3, gotPerson3);
		assertEquals(person4, gotPerson4);
	}

	@Test
	public void containsEmptyQueue() {
		// given
		Queue<Person> queue = new Queue();
		Person person = new Person("Damian");

		// when
		boolean result = queue.contains(person);

		// then
		assertFalse(result);
	}

	@Test
	public void containsNullAfterAddingNull() {
		// given
		Queue<Person> queue = new Queue();
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
		Queue<Person> queue = new Queue();
		queue.add(null);

		// when
		boolean result = queue.contains(person);

		// then
		assertFalse(result);
	}

	@Test
	public void containsPersonAfterAddPerson() {
		// given
		Queue<Person> queue = new Queue();
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
		Queue<Person> queue = new Queue();
		Person person = new Person("Dariusz");
		queue.add(person);

		// when
		boolean result = queue.contains(null);

		// then
		assertFalse(result);
	}

	@Test
	public void containsPersonWithTheSameName() {
		// given
		Queue<Person> queue = new Queue();
		Queue<Person> queue2 = new Queue();
		Person person = new Person("Maciej");
		Person person2 = new Person("Maciej");
		queue.add(person);
		queue2.add(person2);

		// when
		boolean result = queue.contains(person2);

		// then
		assertTrue(result);
	}

	@Test
	public void getSizeOfEmptyQueue() {
		// given
		Queue<Person> queue = new Queue();

		// when
		int result = queue.size();

		// then
		assertEquals(0, result);
	}

	@Test
	public void getSizeOfQueueAfterAddAndRemove() {
		// given
		Queue<Person> queue = new Queue<>();
		queue.add(new Person("Mateusz"));
		queue.get();

		// when
		int result = queue.size();

		// then
		assertEquals(0, result);
	}

	@Test
	public void getSizeOfQueueAfterAddFourObjectsAndRemoveTwoObjects() {
		// given
		Queue<Person> queue = new Queue<>();
		queue.add(new Person("Mateusz"));
		queue.add(new Person("Dariusz"));
		queue.add(new Person("Arkadiusz"));
		queue.add(new Person("Marek"));
		queue.get();
		queue.get();

		// when
		int result = queue.size();

		// then
		assertEquals(2, result);
	}

	@Test
	public void getSizeOfQueueAfterClear() {
		// given
		Queue<Person> queue = new Queue<>();
		queue.add(new Person("Mateusz"));
		queue.add(new Person("Andrzej"));
		queue.add(new Person("Dariusz"));
		queue.add(new Person("Arkadiusz"));
		queue.clear();

		// when
		int result = queue.size();

		// then
		assertEquals(0, result);
	}

	@Test
	public void getSizeOfQueueWithNull() {
		// given
		Queue<Person> queue = new Queue();
		queue.add(null);

		// when
		int result = queue.size();

		// then
		assertEquals(1, result);
	}

	@Test
	public void getSizeOfQueueWithFiveObjects() {
		// given
		Queue<Person> queue = new Queue();
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
	public void equalMethodWithSameObjects() {
		// given
		Queue<Person> queue1 = new Queue();
		Queue<Person> queue2 = new Queue();
		Person person = new Person("Dawid");
		queue1.add(person);
		queue2.add(person);

		// when
		boolean result = queue1.equals(queue2);

		// then
		assertTrue(result);
	}

	@Test
	public void equalMethodWithDifferentObjects() {
		// given
		Queue<Person> queue = new Queue();
		Queue<Person> queue1 = new Queue();
		Person person1 = new Person("Maciek");
		Person person2 = new Person("Darek");
		Person person3 = new Person("Mariusz");
		queue.add(null);
		queue.add(person1);
		queue1.add(null);
		queue1.add(person2);
		queue.add(person3);
		queue1.add(person3);

		// when
		boolean result = queue.equals(queue1);

		// then
		assertFalse(result);
	}

	@Test
	public void equalMethodWithDifferentSize() {
		// given
		Queue<Person> queue = new Queue();
		Queue<Person> queue1 = new Queue();
		Person person1 = new Person("Maciek");
		Person person2 = new Person("Dariusz");
		queue.add(person1);
		queue.add(person2);
		queue1.add(person1);

		// when
		boolean result = queue.equals(queue1);

		// then
		assertFalse(result);
	}

	@Test
	public void equalThis() {
		// given
		Queue<Person> queue = new Queue();

		// when
		boolean result = queue.equals(queue);

		//then
		assertTrue(result);
	}

	@Test
	public void equalsNull() {
		// given
		Queue<Person> queue = new Queue();

		// when
		boolean result = queue.equals(null);

		// then
		assertFalse(result);
	}

	@Test
	public void clearTest() {
		// given
		Queue<Person> queue = new Queue();
		queue.add(new Person("Maciej"));
		queue.add(new Person("Dariusz"));
		queue.add(new Person("Arkadiusz"));

		// when
		queue.clear();

		// then
		assertEquals(0, queue.size());
	}

	@Test
	public void clearWithNull() {
		// given
		Queue<Person> queue = new Queue();
		queue.add(null);
		queue.add(null);
		queue.add(null);

		// when
		queue.clear();

		// then
		assertEquals(0, queue.size());
	}

	@Test
	public void clearEmptyQueue() {
		// given
		Queue<Person> queue = new Queue();

		// when
		queue.clear();

		// then
		assertEquals(0, queue.size());
	}

	@Test
	public void hashCodeTest() {
		// given
		HashSet<Queue> hashSet = new HashSet<>();
		Queue<Person> queue = new Queue();
		Queue<Person> queue1 = new Queue();
		Queue<Person> queue2 = new Queue();
		queue.add(new Person("Maciej"));
		queue1.add(new Person("Dariusz"));
		queue2.add(new Person("Pawel"));
		hashSet.add(queue);
		hashSet.add(queue1);
		hashSet.add(queue2);

		// when
		int result = hashSet.size();

		// then
		assertEquals(3, result);
	}

	@Test
	public void toStringTest() {
		// given
		Queue<Person> queue = new Queue();
		queue.add(new Person("Mateusz"));

		// when
		String result = queue.toString();

		// then
		assertEquals("Person(name=Mateusz)", result);
	}

	@Test
	public void testToStringGetAndSize() {
		// given
		Queue<Person> queue = new Queue();
		Person person = new Person("Maciej");

		// when
		queue.add(person);

		// then
		assertEquals("Person(name=Maciej)", queue.toString());
		assertEquals(person, queue.get());
		assertEquals(1, queue.size());
	}
}
