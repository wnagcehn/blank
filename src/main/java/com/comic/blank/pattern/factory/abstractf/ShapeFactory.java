package com.comic.blank.pattern.factory.abstractf;

import com.comic.blank.pattern.factory.Circle;
import com.comic.blank.pattern.factory.Rectangle;
import com.comic.blank.pattern.factory.Shape;
import com.comic.blank.pattern.factory.Square;

/**
 * created by ..w-chen..
 */
public class ShapeFactory extends AbstarctFactory {

    @Override
    Color getColor(String type) {
        return null;
    }

    @Override
    Shape getShape(String type) {
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
