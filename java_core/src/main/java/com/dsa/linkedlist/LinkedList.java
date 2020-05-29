package com.dsa.linkedlist;

import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {

    private Node<E> head;
    private int size = 0;

    @SafeVarargs
    public static <T> LinkedList<T> of(T... args) {
        LinkedList<T> linkedList = new LinkedList<>();
        if (args != null) {
            for (T arg : args) {
                linkedList.add(arg);
            }
        }
        return linkedList;
    }

    public static void main(String[] args) {
        Node<Integer> node5 = new Node<>(4, null);
        Node<Integer> node4 = new Node<>(4, node5);
        Node<Integer> node3 = new Node<>(4, node4);
        Node<Integer> node2 = new Node<>(4, node3);
        Node<Integer> node1 = new Node<>(4, node2);
        node5.next = node2;
        System.out.println(new LinkedList<Integer>().detectLoop(node1));

    }

    public void add(E data) {
        this.head = new Node<>(data, head);
        this.size++;
    }

    public int size() {
        return this.size;
    }

    public Boolean contains(E data) {
        Node<E> current = this.head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void reverse() {
        this.head = this.reverse0(this.head);
    }

    private Node<E> reverse0(Node<E> root) {
        Node<E> current = root;
        Node<E> prev = null;
        Node<E> next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    private boolean detectLoop(Node<E> root) {
        if (null == root)
            return false;

        Node<E> slower = root;
        Node<E> faster = root;
        while (slower != null && faster != null && faster.next != null) {
            slower = slower.next;
            faster = faster.next.next;
            if (slower == faster) {
                return true;
            }
        }
        return false;
    }

    static class Node<E> {
        private E data;
        private Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

}
