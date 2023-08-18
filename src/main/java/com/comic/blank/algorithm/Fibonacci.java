package com.comic.blank.algorithm;

/**
 * 斐波那契数列
 *
 * 斐波那契数列（Fibonacci sequence），又称黄金分割数列、因数学家莱昂纳多·斐波那契（Leonardoda Fibonacci）以兔子繁殖为例子而引入，
 * 故又称为“兔子数列”。有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，
 * 假如兔子都不死，问每个月的兔子总数为多少？
 *
 * 兔子的规律为数列：0、1、1、2、3、5、8、13、21、34、........ 这里的数列指的是对数
 *
 * @author ..w-chen..
 */
public class Fibonacci {

    public static void main(String[] args) {
        // 要计算的斐波那契数列的项数
        int n = 10;
        for (int i = 0; i < n; i++) {
            System.out.println(calcuFibonacci(i));
        }
    }

    private static int calcuFibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return calcuFibonacci(n - 2) + calcuFibonacci(n - 1);
        }
    }

}
