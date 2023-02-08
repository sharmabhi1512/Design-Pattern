package com.abhi.factory.person;

public class Male implements Person {
    @Override
    public void wish(String msg) {
        System.out.println("This is me who wish "+msg);
    }
}
