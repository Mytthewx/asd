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
        queue.add(person1);
        queue.add(person2);
        queue.add(person3);
        queue.add(person4);
        queue.add(person5);
        queue.add(person6);
        System.out.println("Size of queue = " + queue.size());
        queue.clear();
        queue.removeFirst();
        //System.out.println(queue);
        //System.out.println(queue.sizeOf());
        //queue.clear();
        //System.out.println(queue);
    }
}
