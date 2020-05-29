package com.dsa.linkedlist;

import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import java.util.Iterator;

@RunWith(JUnit4ClassRunner.class)
public class LinkedListTest {

    @Test
    public void testAdd() {
        LinkedList<Integer> linkedList = LinkedList.of(1, 2, 3);
        Assert.assertTrue(linkedList.contains(1));
        Assert.assertTrue(linkedList.contains(2));
        Assert.assertTrue(linkedList.contains(3));
        Assert.assertEquals(3, linkedList.size());
    }

    @Test
    public void testReverse() {
        LinkedList<Integer> linkedList = LinkedList.of(1, 2, 3);
        linkedList.reverse();
        Iterator<Integer> itr = linkedList.iterator();
        Assert.assertEquals(new Integer(1), itr.next());
        Assert.assertEquals(new Integer(2), itr.next());
        Assert.assertEquals(new Integer(3), itr.next());
    }
}
