package com.corepattern.propertyreader;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Reflectionroblem {
    public static void main(String args []){
        DateUtil instance1 = DateUtil.getInstance();
        DateUtil instance2 = null;
        Constructor[] constructors = DateUtil.class.getDeclaredConstructors();

        for (Constructor constructor: constructors) {
            constructor.setAccessible(true);
            try {
                instance2 = (DateUtil) constructor.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        // We can use Enum to resolve this issue
        System.out.println(instance1 == instance2);
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
        System.out.println(instance1.hashCode() == instance2.hashCode());


    }
}
