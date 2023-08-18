package com.comic.blank.algorithm;

/**
 * 水仙花数
 *
 * 水仙花数，也称为阿姆斯特朗数，是指一个 n 位数，其各位数字的 n 次方之和等于该数本身。
 * 例如，153 是一个水仙花数，因为 1^3 + 5^3 + 3^3 = 153。
 *
 * @author ..w-chen..
 */
public class ArmstrongNumber {

    public static void main(String[] args) {
        int lowerLimit = 100;
        int upperLimit = 999;

        for (int i = lowerLimit; i < upperLimit; i++) {
            if (isArmstrongNumber(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isArmstrongNumber(int num) {
        // 获取个、十、百位
        int a = num % 10;
        int b = num / 10 % 10;
        int c = num / 100;
        return (int) StrictMath.pow(a, 3) + (int) StrictMath.pow(b, 3) + (int) StrictMath.pow(c, 3) == num;
    }

}
