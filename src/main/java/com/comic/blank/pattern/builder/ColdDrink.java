package com.comic.blank.pattern.builder;

/**
 * created by ..w-chen..
 */
public abstract class ColdDrink implements Item {

    public Packing packing() {
        return new Bottle();
    }

    public abstract float price();

}
