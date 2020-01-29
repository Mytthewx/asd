package com.company;

import java.util.Objects;

public class Person {
    private String name;
    private Person prev;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Person {" +
                "name='" + name + "']";
    }
}
