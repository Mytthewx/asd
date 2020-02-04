package com.company;

public class Queue {
    private Node last;

    private static class Node {
        private Node prev;
        private Person person;

        public Node(Person person) {
            this.person = person;
        }

        public Person getPerson() {
            return person;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        @Override
        public int hashCode() {
            return person.hashCode();
        }

        @Override
        public String toString() {
            return String.valueOf(person);
        }
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
        if (walking.getPerson().equals(walking2.getPerson())) {
            do {
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
        Node walking = last;
        int prime = 3;
        int result = 1;
        do {
            result = prime * result + (walking.hashCode());
            walking = walking.getPrev();
        } while (walking != null);
        return result;
    }


    public boolean contains(Person person) {
        Node walking = last;
        do {
            if (walking.getPerson() == person) {
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