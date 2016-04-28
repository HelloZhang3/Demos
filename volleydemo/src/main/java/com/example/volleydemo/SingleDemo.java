package com.example.volleydemo;

/**
 * 单例模式
 * Created by Administrator on 2016/4/7 0007.
 */
public class SingleDemo {
    private static SingleDemo instance = null;

    public static synchronized SingleDemo getInstance() {
        if (instance == null) {
            instance = new SingleDemo();
        }
        return instance;
    }

    private SingleDemo() {
    }
}
