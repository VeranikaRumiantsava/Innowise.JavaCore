package org.innowise.internship.javacore.customlinkedlist.customlinkedlist;

public class Node<T> {
    private final T item;
    private Node<T> next = null;

    public Node(T item) {
        this.item = item;
        this.next = null;
    }

    //mb it's 'item' not 'info'
    public T getItem() {
        return item;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
