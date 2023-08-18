package com.comic.blank.time;

import lombok.Data;

/**
 * 整型区间
 *
 * @author ..w-chen..
 */
@Data
public class IntegerSlot {

    private String key;

    private Integer start;

    private Integer end;

    public IntegerSlot(Integer start, Integer end, String key) {
        if (start.compareTo(end) > 0) {
            this.start = end;
            this.end = start;
            this.key = key;
        } else {
            this.start = start;
            this.end = end;
            this.key = key;
        }
    }

}
