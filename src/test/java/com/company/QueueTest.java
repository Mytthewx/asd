package com.company;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueueTest {
    @Test
    public void getCorrectPersonAfterAdd() {
        // given
        Queue queue = new Queue();
        Person person = new Person("Maciej");
        // when
        Person gotPerson = queue.removeFirst();
        // then
        assertEquals(person, gotPerson);
    }
}