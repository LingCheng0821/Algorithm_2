package com.lock;


/**
 * Created by Laura on 2018/3/28.
 */
public class TestSynchronized {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread thread = new MyThread();
            thread.start();
        }
    }
}

class MyThread extends Thread {
    public void run() {
        Sync sync = new Sync();
        sync.test();
    }
}
class Sync{
    public  void test() {
        synchronized(this) {
            System.out.println("test开始..");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test结束..");
        }
    }
}



