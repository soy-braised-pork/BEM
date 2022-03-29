package com.example.demo.dao;

/**
 * @author zlx
 * Creat on 2022-03-23
 */
public class test implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println(i);
        }
    }


    public static void main(String[] args) {
        ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
        test test = new test();
        test test1 = new test();
        test.run();
        test1.run();
        objectThreadLocal.set(test);
    }
}
