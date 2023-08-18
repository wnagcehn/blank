package com.comic.blank.pattern.factory.abstractf;

/**
 * created by ..w-chen..
 */
public class AbstractFactoryDemo {

    public static void main(String[] args) {
        AbstarctFactory factory = FactoryProducer.getFactory("Color");
        if (null == factory) {
            return;
        }

        Color red = factory.getColor("Red");
        red.fill();
        Color yellow = factory.getColor("Yellow");
        yellow.fill();
        Color blue = factory.getColor("Blue");
        blue.fill();
    }

}
