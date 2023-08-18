package com.comic.blank.utils;

import cn.hutool.core.util.StrUtil;

/**
 * 校验密码工具类
 *
 * @author ..w-chen..
 */
public class PwdCheckUtils {

    //定义特殊字符
    private static final String SPECIAL_CHAR = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

    /**
     * 校验密码长度是否符合要求
     *
     * @param password 密码
     * @param minNum   最小长度
     * @param maxNum   最大长度
     * @return true/false
     */
    public static boolean checkPasswordLength(String password, String minNum, String maxNum) {
        boolean flag = false;
        if (StrUtil.isBlank(maxNum)) {
            minNum = StrUtil.isBlank(minNum) ? "0" : minNum;
            if (password.length() >= Integer.parseInt(minNum)) {
                flag = true;
            }
        } else {
            minNum = StrUtil.isBlank(minNum) ? "0" : minNum;
            if (password.length() >= Integer.parseInt(minNum) &&
                    password.length() <= Integer.parseInt(maxNum)) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 校验密码是否包含数字
     *
     * @param password 密码
     * @return true/false
     */
    public static boolean checkContainDigit(String password) {
        char[] chPass = password.toCharArray();
        for (char pass : chPass) {
            if (Character.isDigit(pass)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 校验密码是否包含字母（不区分大小写）
     *
     * @param password 密码
     * @return true/false
     */
    public static boolean checkContainCase(String password) {
        char[] chPass = password.toCharArray();
        for (char pass : chPass) {
            if (Character.isLetter(pass)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 校验密码是否包含小写字母
     *
     * @param password 密码
     * @return true/false
     */
    public static boolean checkContainLowerCase(String password) {
        char[] chPass = password.toCharArray();
        for (char pass : chPass) {
            if (Character.isLowerCase(pass)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 校验密码是否包含大写字母
     *
     * @param password 密码
     * @return true/false
     */
    public static boolean checkContainUpperCase(String password) {
        char[] chPass = password.toCharArray();
        for (char pass : chPass) {
            if (Character.isUpperCase(pass)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 校验密码是否包含特殊字符
     *
     * @param password 密码
     * @return true/false
     */
    public static boolean checkContainSpecialChar(String password) {
        char[] chPass = password.toCharArray();
        for (char pass : chPass) {
            if (SPECIAL_CHAR.indexOf(pass) != -1) {
                return true;
            }
        }
        return false;
    }

}

