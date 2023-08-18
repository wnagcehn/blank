package com.comic.blank.pattern.single;

/**
 * created by ..w-chen..
 */
public class SingleDemo {

    public static void main(String[] args) {
        SingleObject singleObject = SingleObject.getInstance();
        singleObject.printMessage();
    }

}
