package com.company;

public class Main {

    public static void main(String[] args) {
        Queue queue = new Queue();
        Person person1 = new Person("Mateusz");
        Person person2 = new Person("Andrzej");
        Person person3 = new Person("Daniel");
        Person person4 = new Person("Krystian");
        Person person5 = new Person("Wojciech");
        Person person6 = new Person("Błażej");
        queue.addHumanToQueue(person1);
        queue.addHumanToQueue(person2);
        queue.addHumanToQueue(person3);
        queue.addHumanToQueue(person4);
        queue.addHumanToQueue(person5);
        queue.addHumanToQueue(person6);
        System.out.println(person6);
    }
}
