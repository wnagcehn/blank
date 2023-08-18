package com.comic.blank.genericity;

/**
 * @author ..w-chen..
 */
public class GenTest {

    public static void main(String[] args) {
        String a = "{\"type\":\"PRODUCT_SET_UPDATE\",\"payload\":[{\"a\":\"6924922202394\",\"b\":\"PC\"},{\"a\":\"123\",\"b\":\"234\"}]}";
        Event event = Event.parse(a, Payload.class);
        System.out.println(event);
    }

}
