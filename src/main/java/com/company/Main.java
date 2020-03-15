package com.company;

public class Main {

	public static void main(String[] args) {
		Stack<Person> stack = new Stack<>();
		Person person = new Person("Mateusz");
		Person person2 = new Person("Damian");
		Person person3 = new Person("Marek");
		stack.put(person);
		System.out.println(stack.size());
		stack.put(person2);
		System.out.println(stack.size());
		stack.put(person3);
		System.out.println(stack.size());
		System.out.println("Stack: " + stack);
		System.out.println("Top element in a stack: " + stack.peek());
		System.out.println("Delete top element in a stack: " + stack.peek() + " - deleted.");
		System.out.println("Is " + person.toString() + " in stack?: " + stack.contains(person));
		stack.clear();
		System.out.println("Stack after clear: " + stack);
	}
}
