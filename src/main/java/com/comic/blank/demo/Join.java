package com.comic.blank.demo;

/**
 * 如果一个线程A执行了thread.join()语句，线程A会等待thread执行完后继续执行
 */
public class Join {

    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Demo(mainThread));
            thread.start();
            mainThread = thread;
        }
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName() + " terminate.");
    }

    static class Demo implements Runnable {
        private Thread thread;
        Demo(Thread thread) {
            this.thread = thread;
        }

        public void run() {
            try {
                thread.join();
            } catch (InterruptedException ignored) {

            }
            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }

}
