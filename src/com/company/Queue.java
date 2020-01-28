package com.company;

public class Queue {
    Person last;
    
    public Person removeFirst() {
        Person walking = last;
        System.out.println(walking);
        do {
            walking = walking.getPrev();
            System.out.println(walking);
        } while (walking.getPrev() != null);
        System.out.println("Last person in queue is: " + walking);
        walking = null;
        return walking;
    }

    public void add(Person person) {
        person.setPrev(last);
        last = person;
    }

    public void clear() {
        System.out.println(last);
    }

    public int size() {
        Person walking = last;
        if (walking == null) {
            return 0;
        }
        int counter = 0;
        do {
            walking = walking.getPrev();
            counter++;
        } while (walking != null);
        return counter;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "person=" + last +
                '}';
    }
}

