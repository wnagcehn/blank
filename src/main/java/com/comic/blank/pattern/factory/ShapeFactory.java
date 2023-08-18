package com.comic.blank.pattern.factory;

/**
 * created by ..w-chen..
 */
public class ShapeFactory {

    public Shape create(String type) {
        if (null == type) {
            return null;
        } else if ("Circle".equals(type)) {
            return new Circle();
        } else if ("Rectangle".equals(type)) {
            return new Rectangle();
        } else if ("Square".equals(type)) {
            return new Square();
        }
        return null;
    }

}
