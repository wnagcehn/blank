package com.comic.blank.algorithm;

/**
 * 猴子吃桃问题
 *
 * 有一只猴子第一天摘下若干个桃子，当即吃了一半，还不过瘾，又多吃了一个。
 * 第二天又将剩下的桃子吃了一半，又多吃了一个。以后每天都是吃前一天剩下的一半零一个。
 * 到第10天再想吃时，只剩下一个桃子了。问第一天共摘了多少个桃子？
 *
 * @author ..w-chen..
 */
public class MonkeyPeach {

    public static void main(String[] args) {
        int day = 1;
        // 计算第一天吃多少个桃子
        System.out.println(calcuPeachCount(10));
        System.out.println(calcuPeachCount(1));
    }

    private static int calcuPeachCount(int day) {
        if (day == 10) {
            return 1;
        } else {
            // 后一天的桃子数加一，再翻倍
            return (calcuPeachCount(day + 1) + 1) << 1;
        }
    }

}
