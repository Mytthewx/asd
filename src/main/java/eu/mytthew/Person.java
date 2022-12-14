package eu.mytthew;

import lombok.Data;

@Data
public class Person implements Comparable<Person> {
	String name;
	int age;

	@Deprecated
	public Person() {
		this(0);
	}

	@Deprecated
	public Person(String name) {
		this(name, 0);
	}

	public Person(int age) {
		this("test", age);
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Person person) {
		return age - person.age;
	}
}
