package com.company;

public class Person {
    String name;
    Person prev;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Person getPrev() {
        return prev;
    }

    public void setPrev(Person prev) {
        this.prev = prev;
    }

    @Override
    public boolean equals(Object obj) {
        Person person = (Person) obj;
        //Kod do poprawki
        return false;
    }

    @Override
    public String toString() {
        return "Person {" +
                "name='" + name + "']";
    }
}
