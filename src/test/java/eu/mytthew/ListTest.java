package eu.mytthew;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class ListTest {
	@Test
	public void getPersonWithIndexZero() {
		// given
		List<Person> list = new List<>();
		Person person = new Person("Daniel");
		list.add(person);
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

	// shouldThrowExceptionGettingPersonOnNonExistingIndex
	@Test(expected = IndexOutOfBoundsException.class)
	public void getObjectAfterAddToListAndThenRemoveFromListUsingIndexOfObject() {
		// given
		List<Person> list = new List<>();
		list.add(new Person("Mateusz"));
		list.add(new Person("Daniel"));
		list.remove(1);

		// when
		list.get(1);
	}

	@Test
	public void removePersonAfterAddingPersonWithObjectArg() {
		// given
		List<Person> list = new List<>();
		Person person = new Person("Mateusz");
		list.add(person);

		// when
		int result = list.remove(person);

		// then
		assertEquals(0, result);
		assertFalse(list.contains(person));
		assertEquals(0, list.size());
	}

	@Test
	public void removePersonAfterAddingPersonWithIndexArg() {
		// given
		List<Person> list = new List<>();
		Person person = new Person("Mateusz");
		list.add(person);

		// when
		Person result = list.remove(0);

		// then
		assertEquals(person, result);
		assertFalse(list.contains(person));
		assertEquals(0, list.size());
	}

	@Test
	public void removePersonAfterAddingPersonAndBeforeAddingSecondPerson() {
		// given
		List<Person> list = new List<>();
		Person person = new Person("Mateusz");
		Person person2 = new Person("Andrzej");
		list.add(person);

		// when
		list.remove(person);
		list.add(person2);

		// then
		assertFalse(list.contains(person));
		assertTrue(list.contains(person2));
		assertEquals(1, list.size());
		assertFalse(list.contains(null));
	}

	@Test
	public void removePersonWithIndex() {
		// given
		List<Person> list = new List<>();
		Person person = new Person("Mariusz");
		Person person2 = new Person("Marek");
		list.add(person);
		list.add(person2);

		// when
		Person result = list.remove(0);

		// then
		assertEquals(1, list.size());
		assertEquals(person, result);
		assertFalse(list.contains(person));
		assertTrue(list.contains(person2));
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
		int result = list.remove(person1);

		// then
		assertTrue(list.contains(person2));
		assertFalse(list.contains(person1));
		assertEquals(1, list.size());
		assertEquals(0, result);
	}

	@Test
	public void removePersonWithIndexAfterAddingThreeObjects() {
		// given
		List<Person> list = new List<>();
		Person person1 = new Person("Mateusz");
		Person person2 = new Person("Dawid");
		Person person3 = new Person("Maciej");
		list.add(person1);
		list.add(person2);
		list.add(person3);

		// when
		Person result = list.remove(1);

		// then
		assertFalse(list.contains(person2));
		assertTrue(list.contains(person1));
		assertTrue(list.contains(person3));
		assertEquals(2, list.size());
		assertEquals(person2, result);
	}

	@Test
	public void removePersonWithObjectAfterAddingThreeObjects() {
		// given
		List<Person> list = new List<>();
		Person person1 = new Person("Mateusz");
		Person person2 = new Person("Dawid");
		Person person3 = new Person("Maciej");
		list.add(person1);
		list.add(person2);
		list.add(person3);

		// when
		int result = list.remove(person2);

		// then
		assertFalse(list.contains(person2));
		assertTrue(list.contains(person1));
		assertTrue(list.contains(person3));
		assertEquals(2, list.size());
		assertEquals(1, result);
	}

	@Test
	public void removeNewPerson() {
		// given
		List<Person> list = new List<>();
		list.add(new Person("Maciej"));

		// when
		int result = list.remove(new Person("Damian"));

		// then
		assertFalse(list.contains(new Person("Damian")));
		assertTrue(list.contains(new Person("Maciej")));
		assertEquals(-1, result);
		assertEquals(1, list.size());
	}

	@Test
	public void removeNewPersonWithTheSameName() {
		// given
		List<Person> list = new List<>();
		list.add(new Person("Maciej"));

		// when
		int result = list.remove(new Person("Maciej"));

		// then
		assertEquals(0, result);
		assertEquals(0, list.size());
	}

	@Test
	public void removeObjectAfterAddingNull() {
		// given
		List<Person> list = new List<>();
		Person person = new Person("Mateusz");
		list.add(null);

		// when
		int result = list.remove(person);

		// then
		assertEquals(-1, result);
		assertTrue(list.contains(null));
		assertFalse(list.contains(person));
	}

	@Test
	public void removeNullAfterAddingNull() {
		// given
		List<Person> list = new List<>();
		list.add(null);

		// when
		int result = list.remove(null);

		// then
		assertEquals(0, result);
		assertEquals(0, list.size());
		assertFalse(list.contains(null));
	}

	@Test
	public void removeObjectFromListWithSizeZero() {
		// given
		List<Person> list = new List<>();

		// when
		int result = list.remove(null);

		// then
		assertEquals(0, result);
		assertEquals(0, list.size());
		assertFalse(list.contains(null));
	}

	@Test
	public void removeObjectFromList() {
		// given
		List<Person> list = new List<>();
		Person person1 = new Person("Mateusz");
		Person person2 = new Person("Marcin");
		Person person3 = new Person("Damian");
		Person person4 = new Person("Andrzej");
		list.add(person1);
		list.add(person2);
		list.add(person3);
		list.add(person4);

		// when
		int result = list.remove(person2);

		// then
		assertEquals(1, result);
		assertEquals(3, list.size());
		assertFalse(list.contains(person2));
		assertTrue(list.contains(person1));
		assertTrue(list.contains(person3));
		assertTrue(list.contains(person4));
	}

	@Test
	public void removeNonExistObjectFromList() {
		// given
		List<Person> list = new List<>();
		Person person = new Person("Mateusz");
		Person person2 = new Person("Damian");
		list.add(person);
		list.add(person2);

		// when
		int result = list.remove(null);

		// then
		assertEquals(-1, result);
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
		// given
		List<Person> list = new List<>();
		Person person = new Person("Mateusz");

		// when
		boolean result = list.contains(null);
		boolean result2 = list.contains(person);

		// then
		assertFalse(result);
		assertFalse(result2);
	}

	@Test
	public void containsTheSameObjects() {
		// given
		List<Person> list = new List<>();
		Person person = new Person("Mateusz");
		Person person2 = new Person("Mateusz");
		list.add(person);

		// when
		boolean result = list.contains(person2);

		// then
		assertTrue(result);
	}

	@Test
	public void containsAfterAddingPersonThenNullAndPerson() {
		// given
		List<Person> list = new List<>();
		list.add(new Person("Maciej"));
		list.add(null);
		list.add(new Person("Damian"));
		list.remove(null);

		// when
		boolean result = list.contains(null);

		// then
		assertFalse(result);
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
		assertEquals(list.get(0), person);
		assertEquals(list.get(1), person1);
		assertEquals(list.get(2), person);
	}

	@Test
	public void setNull() {
		// given
		List<Person> list = new List<>();
		Person person = new Person("Maciej");
		Person person2 = new Person("Marek");
		list.add(person);
		list.add(new Person("Darek"));
		list.add(person2);

		// when
		list.set(1, null);

		// then
		assertEquals(list.get(0), person);
		assertNull(list.get(1));
		assertEquals(list.get(2), person2);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void setOnIndexOutOfRange() {
		// given
		List<Person> list = new List<>();
		Person person = new Person("Andrzej");

		// when
		list.set(8937289, person);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void setOnNonExistentIndex() {
		// given
		List<Person> list = new List<>();
		Person person = new Person("Andrzej");

		// when
		list.set(5, person);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void setOnMinusIndex() {
		// given
		List<Person> list = new List<>();
		Person person = new Person("Andrzej");

		// when
		list.set(-1, person);
	}

	@Test
	public void equalMethodWithSameObjects() {
		// given
		List<Person> list1 = new List<>();
		List<Person> list2 = new List<>();
		Person person = new Person("Dawid");
		list1.add(person);
		list2.add(person);

		// when
		boolean result = list1.equals(list2);

		// then
		assertTrue(result);
	}

	@Test
	public void equalMethodWithDifferentObjects() {
		// given
		List<Person> list1 = new List<>();
		List<Person> list2 = new List<>();
		Person person1 = new Person("Maciek");
		Person person2 = new Person("Darek");
		Person person3 = new Person("Mariusz");
		list1.add(null);
		list1.add(person1);
		list2.add(null);
		list2.add(person2);
		list1.add(person3);
		list2.add(person3);

		// when
		boolean result = list1.equals(list2);

		// then
		assertFalse(result);
	}

	@Test
	public void equalMethodWithDifferentSize() {
		// given
		List<Person> list1 = new List<>();
		List<Person> list2 = new List<>();
		Person person1 = new Person("Maciek");
		Person person2 = new Person("Dariusz");
		list1.add(person1);
		list1.add(person2);
		list2.add(person1);

		// when
		boolean result = list1.equals(list2);

		// then
		assertFalse(result);
	}

	@Test
	public void equalThis() {
		// given
		List<Person> list = new List<>();

		// when
		boolean result = list.equals(list);

		//then
		assertTrue(result);
	}

	@Test
	public void equalsNull() {
		// given
		List<Person> list = new List<>();

		// when
		boolean result = list.equals(null);

		// then
		assertFalse(result);
	}

	@Test
	public void clearTest() {
		// given
		List<Person> list = new List<>();
		list.add(new Person("Maciej"));
		list.add(new Person("Dariusz"));
		list.add(new Person("Arkadiusz"));

		// when
		list.clear();

		// then
		assertEquals(0, list.size());
	}

	@Test
	public void clearWithNull() {
		// given
		List<Person> list = new List<>();
		list.add(null);
		list.add(null);
		list.add(null);

		// when
		list.clear();

		// then
		assertEquals(0, list.size());
	}

	@Test
	public void clearEmptyList() {
		// given
		List<Person> list = new List<>();

		// when
		list.clear();

		// then
		assertEquals(0, list.size());
	}

	@Test
	public void hashCodeTest() {
		// given
		HashSet<List> hashSet = new HashSet<>();
		List<Person> list = new List<>();
		List<Person> list1 = new List<>();
		List<Person> list2 = new List<>();
		list.add(new Person("Maciej"));
		list1.add(new Person("Dariusz"));
		list2.add(new Person("Pawel"));
		hashSet.add(list);
		hashSet.add(list1);
		hashSet.add(list2);

		// when
		int result = hashSet.size();

		// then
		assertEquals(3, result);
	}

	@Test
	public void toStringTest() {
		// given
		List<Person> list = new List<>();
		list.add(new Person("Mateusz"));

		// when
		String result = list.toString();

		// then
		assertEquals("Person(name=Mateusz, age=0)", result);
	}

	@Test
	public void testToStringGetAndSize() {
		// given
		List<Person> list = new List<>();
		Person person = new Person("Maciej");

		// when
		list.add(person);

		// then
		assertEquals("Person(name=Maciej, age=0)", list.toString());
		assertEquals(person, list.get(0));
		assertEquals(1, list.size());
	}
}
