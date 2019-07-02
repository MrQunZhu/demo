package com.example.demo.test;

/**
 * author: lixq
 * date: 2019/2/19
 * 描述:
 */
public class Son extends Parent {
    @Override
    public void say(Double num){
        this.say(num);
    }

    @Override
    public void song(){
        this.song();
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.song();
    }
}
