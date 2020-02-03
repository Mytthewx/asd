package com.company;

import java.util.Objects;

public class Queue {
    private class Node {
        private Node prev;
        private Person person;

        public Node(Person person) {
            this.person = person;
        }

        public Person getPerson() {
            return person;
        }

        public void setPerson(Person person) {
            this.person = person;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "prev=" + prev +
                    ", person=" + person +
                    '}';
        }
    }

    private Node last;

    public Node getLast() {
        return last;
    }

    public Person removeFirst() {
        Node walking = last;
        do {
            walking = walking.getPrev();
        } while (walking.getPrev().getPrev() != null);
        Person flag = walking.getPrev().getPerson();
        walking.getPrev().setPrev(null);
        return flag;
    }

    public void add(Person person) {
        Node node = new Node(person);
        node.setPrev(last);
        last = node;
    }

    public int size() {
        Node walking = last;
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

    //Do poprawy metoda 'equals'
    @Override
    public boolean equals(Object o) {
        Queue queue = (Queue) o;
        if (size() != queue.size()) {
            return false;
        }
        Node walking = last;
        Node walking2 = queue.last;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (walking.getPerson() == walking2.getPerson()) {
            do {
                System.out.println("Walking = " + walking.getPerson());
                System.out.println("Walking2 = " + walking2.getPerson());
                if (walking.getPerson() != walking2.getPerson()) {
                    return false;
                }
                walking = walking.getPrev();
                walking2 = walking2.getPrev();
            } while (walking != null);
        }
        return true;
    }


    @Override
    public int hashCode() {
        return Objects.hash(last);
    }

    public void clear() {
        last = null;
    }
}

