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
        queue.add(person2);
        queue.add(person3);
        queue1.add(person1);
        queue1.add(person2);
        queue1.add(person3);
        System.out.println("The queue consists of " + queue1.size() + " people.");
        //System.out.println(person1.equals(person3));
        //System.out.println(queue.equals(queue1));
    }
}
