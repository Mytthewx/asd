package com.company;

public class Main {

    public static void main(String[] args) {
        Queue queue = new Queue();
        Queue queue1 = new Queue();
        Person person1 = new Person("Mateusz");
        Person person2 = new Person("Andrzej");
        Person person3 = new Person("Marcin");
        Person person4 = new Person("Krystian");
        queue.add(person1);
        queue1.add(person1);
        System.out.println(queue1.equals(queue));

    }
}