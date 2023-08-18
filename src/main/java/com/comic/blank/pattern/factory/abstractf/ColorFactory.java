package com.comic.blank.pattern.factory.abstractf;

import com.comic.blank.pattern.factory.Shape;

/**
 * created by ..w-chen..
 */
public class ColorFactory extends AbstarctFactory {

    @Override
    Color getColor(String type) {
        if ("Red".equalsIgnoreCase(type)) {
            return new Red();
        } else if("Yellow".equalsIgnoreCase(type)) {
            return new Yellow();
        } else if ("Blue".equalsIgnoreCase(type)) {
            return new Blue();
        }
        return null;
    }

    @Override
    Shape getShape(String type) {
        return null;
    }

}
