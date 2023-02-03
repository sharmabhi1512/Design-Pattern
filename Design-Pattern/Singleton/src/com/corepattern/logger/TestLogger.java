package com.corepattern.logger;

public class TestLogger {

    public static void main(String str[]) {
        Logger logger1 = Logger.getInstance();
        Logger logger3 = Logger.getInstance();
        Logger logger2 = null;
        try {
            logger2 = (Logger) logger1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(logger3  == logger2);
        System.out.println(logger1  == logger2);
        System.out.println(logger1  == logger3);

        logger1.log("Abc");
        logger2.log("Xyz");
    }
}
