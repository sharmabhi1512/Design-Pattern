package com.corepattern.logger;

public class Logger implements Cloneable {

    public static volatile Logger instance;

    private Logger(){
    }

    public static Logger getInstance(){
        if(instance == null){
            synchronized (Logger.class){
                if (instance == null){
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String str){
        System.out.println(str);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
