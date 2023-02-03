package com.corepattern.propertyreader;

public class TestEnumSingleton {

    public static void main(String args[]){

        SingletonEnum instance = SingletonEnum.INSTANCE;

        System.out.println(instance.getName());
        instance.setName("Abc");
        System.out.println(instance.getName());
    }
}
