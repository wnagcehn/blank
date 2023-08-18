package com.comic.blank.pattern.factory.abstractf;

/**
 * created by ..w-chen..
 */
public class FactoryProducer {

    public static AbstarctFactory getFactory(String choice) {
        if ("Color".equalsIgnoreCase(choice)) {
            return new ColorFactory();
        } else if ("Shape".equalsIgnoreCase(choice)) {
            return new ShapeFactory();
        }
        return null;
    }

}
