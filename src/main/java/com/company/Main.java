package com.company;

public class Main {

	public static void main(String[] args) {
		Stack<Person> stack = new Stack<>();
		Person person = new Person("Mateusz");
		stack.add(person);
		System.out.println(stack);
	}
}
