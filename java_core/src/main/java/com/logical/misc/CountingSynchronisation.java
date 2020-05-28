package com.logical.misc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountingSynchronisation {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        OddEvenPrinter oddEvenPrinter = new OddEvenPrinter();
        Runnable task1 = oddEvenPrinter::printOdd;
        Runnable task2 = oddEvenPrinter::printEven;
        es.submit(task1);
        es.submit(task2);
        es.shutdown();
    }
}


class OddEvenPrinter {

    private int i = 1;
    private int limit = 100;

    public synchronized void printOdd() {
        while (i < limit) {
            if (i % 2 == 0) {
                try {
                    wait();
                } catch (Exception ignored) {
                }
            }
            if (i <= limit) {
                System.out.println(i + " printOdd() " + Thread.currentThread().getName());
                i++;
                notifyAll();
            }
        }
    }

    public synchronized void printEven() {
        while (i < limit) {
            if (i % 2 != 0) {
                try {
                    wait();
                } catch (Exception ignored) {
                }
            }
            if (i <= limit) {
                System.out.println(i + " printEven() " + Thread.currentThread().getName());
                i++;
                notifyAll();
            }
        }
    }

}
