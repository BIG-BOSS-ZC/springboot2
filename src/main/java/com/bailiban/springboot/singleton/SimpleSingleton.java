package com.bailiban.springboot.singleton;

public class SimpleSingleton {
    //饿汉单例
    private static SimpleSingleton instance=new SimpleSingleton();

    private SimpleSingleton(){
    }

    public static SimpleSingleton  getInstance() {
        return instance;
    }
}
