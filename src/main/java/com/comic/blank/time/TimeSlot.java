package com.comic.blank.time;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ..w-chen..
 */
@Data
public class TimeSlot {

    private String materialCode;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    public TimeSlot(LocalDateTime startTime, LocalDateTime endTime) {
        if (startTime.isAfter(endTime)) {
            this.startTime = endTime;
            this.endTime = startTime;
        } else {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public TimeSlot(LocalDateTime startTime, LocalDateTime endTime, String materialCode) {
        if (startTime.isAfter(endTime)) {
            this.startTime = endTime;
            this.endTime = startTime;
            this.materialCode = materialCode;
        } else {
            this.startTime = startTime;
            this.endTime = endTime;
            this.materialCode = materialCode;
        }
    }

}
