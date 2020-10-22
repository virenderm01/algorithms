package com.springboot.practice;


import static org.junit.jupiter.api.Assertions.assertEquals;

class FooTest {

    @org.junit.jupiter.api.Test
    void getBar() {
        Foo foo = new Foo();
        String result = foo.getBar();
        assertEquals("FooBar",result);
    }
}