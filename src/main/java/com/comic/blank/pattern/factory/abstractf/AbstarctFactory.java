package com.comic.blank.pattern.factory.abstractf;

import com.comic.blank.pattern.factory.Shape;

/**
 * created by ..w-chen..
 */
public abstract class AbstarctFactory {

    abstract Color getColor(String type);

    abstract Shape getShape(String type);

}
