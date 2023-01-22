package com.java.java8.features.lamda;

public class P3_ThreadLamda {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("This is from Runnable interface");
            }
        });
        t1.run();

        Thread t2 = new Thread(() ->  System.out.println("This is from Lamda call"));
        t2.run();
    }
}
