package com.company;

import java.util.Objects;

public class Queue {
    private Person last;

    public Person getLast() {
        return last;
    }

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

    @Override
    public boolean equals(Object o) {
        if (last == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Queue queue = (Queue) o;
        if (size() != queue.size()) {
            return false;
        }
        Person walking = getLast();
        Person walking2 = queue.getLast();
//        do {
//            if (!walking.equals(walking2)) {
//                return false;
//            }
//            walking = walking.getPrev();
//            walking2 = walking2.getPrev();
//        } while (walking != null);

        while (walking == null) {
            if (!Objects.equals(walking, walking2)) {
                return false;
            }
            walking = walking.getPrev();
            walking2 = walking2.getPrev();
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(last);
    }

    public void clear() {
        last = null;
    }
}

