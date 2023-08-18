package com.comic.blank.thread;

/**
 * @author ..w-chen..
 */
public class Test {

    public static void main(String[] args)  {
        for (int i = 0; i < 5; i++) {
            TestRunnable runnable = new TestRunnable(String.valueOf(i));
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }

}
