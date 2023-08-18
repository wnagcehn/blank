package com.comic.blank.demo;

import java.util.concurrent.TimeUnit;

/**
 * @author ..w-chen..
 */
public class VolatileDemo {

    public static void main(String[] args) {
        MyData data = new MyData();

        // 启动一个线程修改data的num
        new Thread(() -> {
            System.out.println("线程" + Thread.currentThread().getName() +" 正在执行");
            try {
                TimeUnit.SECONDS.sleep(3L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.add(10);
            System.out.println("线程" +Thread.currentThread().getName() + " 更新后，num值为" + data.num);
        }).start();

        // 看下主线程能否保持可见性
        while (data.num == 0) {
            // 无可见性的话，num为0就无限循环；有可见性的话，num为10 跳出循环
        }
        System.out.println("具有可见性！");
    }

}

class MyData {

    int num = 0;

    public void add(Integer num) {
        this.num = num;
    }

}