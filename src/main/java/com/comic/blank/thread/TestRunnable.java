package com.comic.blank.thread;

/**
 * @author ..w-chen..
 */
public class TestRunnable implements Runnable {

    private String flag;

    public TestRunnable(String str) {
        this.flag = str;
    }

    @Override
    public void run() {
        System.out.println("测试线程" + flag);
    }

}
