package com.corepattern.propertyreader;

import java.io.*;

public class TestSingleton {

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        DateUtil dateUtil1 = DateUtil.getInstance();
        DateUtil dateUtil2 = DateUtil.getInstance();

        System.out.println(dateUtil1 == dateUtil2);   // Output ==========>  true

        // Serialization Example Start
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("C:/Abhi_codebase/Codebase/Design-Pattern/Singleton/file/dateutil.txt")));
        objectOutputStream.writeObject(dateUtil1);

        DateUtil dateUtil3 = null;
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("C:/Abhi_codebase/Codebase/Design-Pattern/Singleton/file/dateutil.txt")));
        dateUtil3 = (DateUtil) objectInputStream.readObject();

        objectInputStream.close();
        objectOutputStream.close();
        //System.out.println(dateUtil1 == dateUtil3); //  Without readResolve method in DateUtil class -> Output ==========>  false

        // After overriding readResolve method now output will be true
        System.out.println(dateUtil1 == dateUtil3); // With readResolve method in DateUtil class ->  Output ==========>  true

        // Serialization Example Stop



    }
}
