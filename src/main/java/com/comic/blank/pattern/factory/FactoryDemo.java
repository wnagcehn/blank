package com.comic.blank.pattern.factory;

/**
 * created by ..w-chen..
 */
public class FactoryDemo {

    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape shape = factory.create("Circle");
        shape.draw();
    }

}
