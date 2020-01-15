package com.bailiban.springboot.singleton;

public class HolderSingleton {
    static class Holder{
        private static HolderSingleton singleton=new HolderSingleton();
    }

    private HolderSingleton(){

    }

    public synchronized static HolderSingleton getSingleton() {
        return Holder.singleton;
    }
}
