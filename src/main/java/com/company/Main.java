package com.company;

public class Main {

    public static void main(String[] args) {
        Queue queue = new Queue();
        Queue queue1 = new Queue();
        Person person1 = new Person("Mateusz");
        queue.add(person1);
        queue1.add(person1);
        System.out.println(queue1.equals(queue));
        queue1.clear();
        System.out.println(queue1.size());
        System.out.println(queue);
    }
}
