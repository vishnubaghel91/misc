package com.concurrency;

import java.lang.management.ManagementFactory;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

public class ProducerConsumerByBlockingQueue {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("process id: " + ManagementFactory.getRuntimeMXBean().getName());
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        Thread t1 = new Thread(new Producer(queue));
        Thread t2 = new Thread(new Consumer(queue));

        t1.start();
        t2.start();
        Thread.sleep(1000);

    }

}

class Producer implements Runnable {

    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {

        IntStream.range(0, 10).forEach(i ->
                {
                    try {
                        Thread.sleep(10000);
                        queue.put(i);
                        System.out.println("produced" + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
    }
}


class Consumer implements Runnable {

    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        IntStream.range(0, 10).forEach(i ->
                {
                    try {
                        int val = queue.take();
                        System.out.println("consumed" + val);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
    }
}
