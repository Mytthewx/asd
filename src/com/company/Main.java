package com.company;

public class Main {

    public static void main(String[] args) {
        Queue queue = new Queue();
        Person person1 = new Person("Mateusz");
        Person person2 = new Person("Andrzej");
        Person person3 = new Person("Marcin");
        Person person4 = new Person("Krystian");
        Person person5 = new Person("Wojciech");
        Person person6 = new Person("Błażej");
        queue.add(person1);
        queue.add(person2);
        queue.add(person3);
        queue.add(person4);
        queue.add(person5);
        queue.add(person6);
        System.out.println("The queue consists of " + queue.size() + " people.");
        queue.clear();
        System.out.println(person1.equals(person3));
    }
}
