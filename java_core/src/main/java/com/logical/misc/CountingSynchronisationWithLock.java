package com.logical.misc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CountingSynchronisationWithLock {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        OddEvenPrinterWithLock oddEvenPrinter = new OddEvenPrinterWithLock();
        Runnable task1 = oddEvenPrinter::printOdd;
        Runnable task2 = oddEvenPrinter::printEven;
        es.submit(task1);
        es.submit(task2);
        es.shutdown();
    }
}


class OddEvenPrinterWithLock {

    private Lock lock = new ReentrantLock();
    private int i = 1;
    private int limit = 100;
    private Condition even = lock.newCondition();
    private Condition odd = lock.newCondition();

    public void printOdd() {
        lock.lock();
        try {
            while (i < limit) {
                if (i % 2 == 0) {
                    odd.await();
                }
                if (i < limit) {
                    System.out.println(i);
                    i++;
                    even.signalAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void printEven() {
        lock.lock();
        try {
            while (i < limit) {
                if (i % 2 != 0) {
                    even.await();
                }
                if (i <= limit) {
                    System.out.println(i);
                    i++;
                    odd.signalAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
