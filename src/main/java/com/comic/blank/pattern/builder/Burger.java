package com.comic.blank.pattern.builder;

/**
 * created by ..w-chen..
 */
public abstract class Burger implements Item {

    public Packing packing() {
        return new Wrapper();
    }

    public abstract float price();

}
