package com.company;

public class Main {

	public static void main(String[] args) {
		Map<Person, Integer> map = new Map<>();
		Person person = new Person("Mateusz");
		map.add(person, 23);
		System.out.println(map.toString());
	}
}
