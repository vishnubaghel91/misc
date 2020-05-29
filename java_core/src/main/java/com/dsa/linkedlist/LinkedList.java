package com.dsa.linkedlist;

import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {

    private Node<E> head;
    private int size = 0;

    public void add(E data) {
        this.head = new Node<>(data, head);
        this.size++;
    }

    public int size() {
        return this.size;
    }

    public static <T>  LinkedList<T> of(T ... args) {
        LinkedList<T> linkedList = new LinkedList<>();
        if (args != null) {
            for (T arg: args) {
                linkedList.add(arg);
            }
        }
        return linkedList;
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

    private Node reverse0(Node root) {
        Node<E> current = root;
        Node<E> prev = null;
        Node<E> next = null;

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


    static class Node<E> {
        private E data;
        private Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

}
