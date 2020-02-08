package com.company;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Queue {
    private Node last;

    @Getter
    @Setter
    private static class Node {
        private Node prev;
        private Person person;

        public Node(Person person) {
            this.person = person;
        }

        @Override
        public int hashCode() {
            return person == null ? 0 : person.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return Objects.equals(prev, node.prev) &&
                    Objects.equals(person, node.person);
        }

        @Override
        public String toString() {
            return String.valueOf(person);
        }
    }

    public Person get() {
        Node walking = last;
        if (walking.getPrev() == null) {
            Person flag = walking.getPerson();
            walking.setPerson(null);
            return flag;
        }
        while (walking.getPrev().getPrev() != null) {
            walking = walking.getPrev();
        }
        Person flag = walking.getPrev().getPerson();
        walking.setPrev(null);
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

    @Override
    public boolean equals(Object o) {
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
        Node walking = last;
        Node walking2 = queue.last;
        while (walking != null) {
            if (!walking.equals(walking2)) {
                return false;
            }
            walking = walking.getPrev();
            walking2 = walking2.getPrev();
        }
        return true;
    }


    @Override
    public int hashCode() {
        Node walking = last;
        int prime = 3;
        int result = 1;
        while (walking != null) {
            result = prime * result + (walking.hashCode());
            walking = walking.getPrev();
        }
        return result;
    }


    public boolean contains(Person person) {
        Node walking = last;
        if (size() == 0) {
            return false;
        }
        do {
            if (walking.getPerson() == person) {
                return true;
            }
            if (walking.getPerson() == null) {
                return false;
            }
            if (walking.getPerson().equals(person)) {
                return true;
            }
            walking = walking.getPrev();
        } while (walking != null);
        return false;
    }

    public void clear() {
        last = null;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        do {
            s.append(last.getPerson());
            last = last.prev;
        } while (last != null);
        return s.toString();
    }
}
