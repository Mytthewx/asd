package com.company;

public class Main {

	public static void main(String[] args) {
//		List<Person> list = new List<>();
		Queue queue = new Queue();
		Person person = new Person("Marlena");
		Person person2 = new Person("Mateusz");
		Person person3 = new Person("Andrzej");
		queue.add(person);
		queue.add(person2);
		queue.add(person3);
		System.out.println(queue.size());
	}
}
