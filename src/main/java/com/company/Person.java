package com.company;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }
}