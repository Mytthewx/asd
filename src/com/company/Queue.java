package com.company;

public class Queue {
    Person last;

    public Person removeFirst() {
        Person walking = last;
        do walking = walking.getPrev(); while (walking.getPrev() != null);
        Person flag = walking;
        walking = null;
        return flag;
    }

    public void add(Person person) {
        person.setPrev(last);
        last = person;
    }

    public int size() {
        Person walking = last;
        if (walking == null) return 0;
        int counter = 0;
        do {
            walking = walking.getPrev();
            counter++;
        } while (walking != null);
        return counter;
    }


    public void clear() {
        last = null;
    }
}

