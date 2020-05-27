package com.odp.creational.singleton;

import com.odp.creational.singleton.Singleton;
import com.odp.creational.singleton.SingletonThreadSafe;
import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4ClassRunner.class)
public class SingletonTest {

    @Test
    public void testGetInstance() {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        Assert.assertEquals(singleton1, singleton2);
    }


    /*@Test
    public void testGetInstanceThreadFail() {
        List<Singleton> instances = new ArrayList<>();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            threads.add(new Thread(() -> instances.add(Singleton.getInstance()), "singlton" + i));
        }
        threads.forEach(Thread::start);
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        for (int i = 1; i < instances.size(); i++) {
            Assert.assertEquals(instances.get(0), instances.get(i));
        }
    }*/

    @Test
    public void testGetInstanceThreadSafe() {
        List<SingletonThreadSafe> instances = new ArrayList<>();
        Thread t1 = new Thread(() -> instances.add(SingletonThreadSafe.getInstance()), "singlton1");
        Thread t2 = new Thread(() -> instances.add(SingletonThreadSafe.getInstance()), "singlton2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(instances.get(0), instances.get(1));
    }


}
