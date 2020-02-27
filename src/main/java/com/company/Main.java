package com.company;

public class Main {

	public static void main(String[] args) {
		List<Person> list = new List<>();
		Person person = new Person("Adam");
		Person person2 = new Person("Mateusz");
		Person person3 = new Person("Andrzej");
		Person person4 = new Person("Marcin");
		list.add(person);
		list.add(person2);
		list.add(person4);
		System.out.println(list.contains(person2));
	}
}
