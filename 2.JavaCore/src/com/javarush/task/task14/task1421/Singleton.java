package com.javarush.task.task14.task1421;

/**
 * Created by User on 07.09.2017.
 */
public class Singleton {
    private Singleton() {}
    private static Singleton instance = new Singleton();
    public static Singleton getInstance() {
        return instance;
    }
}
