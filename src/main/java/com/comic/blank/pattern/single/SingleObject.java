package com.comic.blank.pattern.single;

/**
 * created by ..w-chen..
 */
public class SingleObject {

    private static SingleObject instance = new SingleObject();

    private SingleObject() {}

    public static SingleObject getInstance() {
        return instance;
    }

    public void printMessage() {
        System.out.println("Single case");
    }

}
