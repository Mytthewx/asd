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
		map.remove(person3);
		System.out.println(person.toString() + " = " + map.get(person));
		System.out.println(person2.toString() + " = " + map.get(person2));
		System.out.println(person3.toString() + " = " + map.get(person3));
		System.out.println(map.containsValue(22));
		System.out.println(map.containsValue(25));
		System.out.println(map.containsValue(23));
		System.out.println(map.containsKey(person));
		System.out.println(map.containsKey(person3));
		System.out.println(map.containsKey(person2));
	}
}
