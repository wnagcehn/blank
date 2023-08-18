package com.comic.blank.genericity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.Data;

import java.util.List;

/**
 * @author ..w-chen..
 */
@Data
public class Event<T> {

    private String type;

    private List<T> payload;

    public static <T> Event<T> parse(String json, Class<T> clazz) {
        return JSON.parseObject(json, new TypeReference<Event<T>>(clazz) {
        });
    }

}
