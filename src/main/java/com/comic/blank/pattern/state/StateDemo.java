package com.comic.blank.pattern.state;

/**
 * @author ..w-chen..
 */
public class StateDemo {

    public static void main(String[] args) {
        Button button = new Button();
        button.setState(OffState.instance());
        button.press();
        button.press();
    }

}
