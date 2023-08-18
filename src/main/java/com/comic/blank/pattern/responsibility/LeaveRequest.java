package com.comic.blank.pattern.responsibility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ..w-chen..
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LeaveRequest {

    private int leaveDays;

    private String name;

}
