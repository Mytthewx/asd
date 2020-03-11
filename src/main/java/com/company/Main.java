package com.company;

public class Main {

	public static void main(String[] args) {
		Stack<Person> stack = new Stack<>();
		Person person = new Person("Mateusz");
		Person person2 = new Person("Damian");
		Person person3 = new Person("Marek");
		stack.add(person);
		stack.add(person2);
		stack.add(person3);
		System.out.println("Stack: " + stack);
		stack.clear();
		System.out.println("Stack after clear: " + stack);
	}
}
