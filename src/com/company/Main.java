package com.company;

public class Main {

    public static void main(String[] args) {
        Queue queue = new Queue();
        Queue queue1 = new Queue();
        Person person1 = new Person("Mateusz");
        Person person2 = new Person("Andrzej");
        Person person3 = new Person("Marcin");
        Person person4 = new Person("Krystian");
        Person p = new Person("xyz");
        Queue q1 = new Queue();
        q1.add(null);
        System.out.println(q1.contains(p)); // oczekujemy false
        System.out.println(q1.contains(null)); // oczekujemy true
        Queue q2 = new Queue();
        q2.add(p);
        System.out.println(q2.contains(p)); // oczekujemy true
        System.out.println(q2.contains(null)); // oczekujemy false

    }
}