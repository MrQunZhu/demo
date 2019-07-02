package com.example.demo.liaotian;

/**
 * author: lixq
 * date: 2019/2/21
 * 描述:
 */
public class Singleton {
    private Singleton(){};
    /*private static Singleton singleton = new Singleton();
    public static Singleton getSingleton(){
        return singleton;
    }*/
    private static Singleton singleton = null;
    public static Singleton getSingleton(){
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
