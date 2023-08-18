package com.comic.blank.enums;

import lombok.Getter;

/**
 * @author ..w-chen..
 */
public enum TestEnum {

    帅("1"),
    强("2");

    @Getter
    public String code;

    TestEnum(String code) {
        this.code = code;
    }

    public static String getCodeByName(String name) {
        for (TestEnum status : TestEnum.values()) {
            if (status.name().equals(name)) {
                return status.getCode();
            }
        }
        return null;
    }

}
