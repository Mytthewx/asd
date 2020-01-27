package com.company;

public class Person {
    String name;
    Person prev;

    public Person(String name) {
        this.name = name;
    }

    public Person getPrev() {
        return prev;
    }

    public void setPrev(Person prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "Person {" +
                "name='" + name + "']";
    }
}
