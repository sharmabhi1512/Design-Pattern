package com.abhi.factory.person;

public class PersonSupply {

    public Person getPersonGender(String gender){
        Person p = PersonFactory.createGender(gender);
        p.wish("I am male ");
        return p;
    }
}
