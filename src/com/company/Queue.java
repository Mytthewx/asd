package com.company;

public class Queue {
    Person person;

    public void removeFirstInQueue(Person person) {
        do {
            person = person.getPrev();
            System.out.println(person);
        } while (person.getPrev().getPrev() != null);
        person.setPrev(null);
        System.out.println("Last person in queue is: " + person);
        System.out.println(person.getPrev());
    }


    public void addHumanToQueue(Person last) {
        last.setPrev(person);
        person = last;
    }
}

