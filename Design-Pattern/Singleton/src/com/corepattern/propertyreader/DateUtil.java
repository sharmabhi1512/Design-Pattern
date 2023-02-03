package com.corepattern.propertyreader;

import java.io.Serializable;

public class DateUtil implements Serializable, Cloneable {
    //SerialVersionUID is a unique identifier for each class, JVM uses it to compare the versions of the class ensuring that the
    // same class was used during Serialization is loaded during Deserialization.
    //Specifying one gives more control, though JVM does generate one if you don't specify. The value generated can differ between
    // different compilers. Furthermore, sometimes you just want for some reason to forbid deserialization of old serialized
    // objects [backward incompatibility], and in this case you just have to change the serialVersionUID.
    private static final long serialVersionUID = 1L;

    //Sometime double -checked lock does not work mainly in presence of either optimizing compilers or shared memory
    // multiprocessors. We use volatile keyword to avoid that because Volatile keyword indicates that a field might be modified
    // by multiple threads that are executing at the same time.  Fields that are declared volatile are not subject to compiler
    // optimizations that assume access by a single thread.
    private static volatile DateUtil instance;

    //To avoid instantiation of an object in another class
    private DateUtil() {

    }

    public static DateUtil getInstance(){
        // To make our method thread safe we can add synchronize keyword
        // outer if statement to avoid putting the lock if object is not null
        if (instance == null){
            synchronized (DateUtil.class){
                if (instance == null) {
                    instance = new DateUtil();
                }
            }
        }

        return instance;
    }

    // handle the de-serialization

    //readResolve method is called when ObjectInputStream has read an object from the stream and is preparing to return it to
    // the caller. ObjectInputStream checks whether the class of the object defines the readResolve method.
    private Object readResolve(){
        return instance;
    }

    // handle Singleton break logic by overriding clone method
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }


}
