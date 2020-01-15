package com.bailiban.springboot.singleton;

public class LazySingleton {
    private static LazySingleton singleton;

    private LazySingleton(){

    }

    public synchronized static LazySingleton getSingleton() {
        if(singleton==null){
            singleton=new LazySingleton();
        }
        return singleton;
    }
}
