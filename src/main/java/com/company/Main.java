package com.company;

public class Main {

	public static void main(String[] args) {
		Map<Person, Integer> map = new Map<>();
		Person person = new Person("Mateusz");
		Person person2 = new Person("Marcin");
		Person person3 = new Person("Andrzej");
		map.add(person, 23);
		map.add(person2, 25);
		map.add(person3, 22);
		System.out.println(person.toString() + " = " + map.get(person));
		System.out.println(person2.toString() + " = " + map.get(person2));
		System.out.println(person3.toString() + " = " + map.get(person3));
		System.out.println(map.keySet());
		System.out.println(map.valueSet());
		System.out.println(map.nodeSet());
	}
}
