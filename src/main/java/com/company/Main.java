package com.company;

public class Main {

	public static void main(String[] args) {
		List<Person> list = new List<>();
		Person person = new Person("Adam");
		Person person2 = new Person("Mateusz");
		Person person3 = new Person("Andrzej");
		list.add(person);
		list.add(person2);
		list.add(person3);
		list.remove(1);
		System.out.println(list);
	}
}
