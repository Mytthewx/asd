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


    //Wszystko na dole do poprawy. gora ok

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
        Person walking = last;
        Person walking2 = queue.last;
        if (walking.equals(walking2)) {
            do {
                System.out.println("walking = " + walking);
                System.out.println("walking2 = " + walking2);
                if (walking != walking2) {
                    return false;
                }
                walking = walking.getPrev();
                walking2 = walking2.getPrev();
            } while (walking != null);
            return true;
        }
        return false;
    }


    @Override
    public int hashCode() {
        return Objects.hash(last);
    }

    public void clear() {
        last = null;
    }
}

