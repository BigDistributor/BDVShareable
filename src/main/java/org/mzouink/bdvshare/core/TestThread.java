package org.mzouink.bdvshare.core;

public class TestThread {
    public static void main(String[] args) {
        System.out.println("start");
        new Thread(() -> {
            System.out.println("Start thread");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Done thread");
        }).start();
        System.out.println("End");
    }
}
