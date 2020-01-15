package com.bailiban.springboot.singleton;

public class DoubleCheckSingleton {
    private static volatile DoubleCheckSingleton singleton;

    private DoubleCheckSingleton(){

    }

    public synchronized static DoubleCheckSingleton getSingleton() {
        if(singleton==null){
            synchronized (singleton){
                if(singleton==null){
                    singleton=new DoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }
}
