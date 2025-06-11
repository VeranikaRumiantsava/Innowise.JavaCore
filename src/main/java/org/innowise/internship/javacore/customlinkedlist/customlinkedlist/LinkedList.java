package org.innowise.internship.javacore.customlinkedlist.customlinkedlist;

public class LinkedList<T>{
    private Node<T> head = null;
    private int size = 0;

    //1. size()
    public int size() {
        return this.size;
    }

    //2. addFirst()
    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);

        if (head != null) {
            newNode.setNext(head);
        }
        head = newNode;
        ++size;
    }

    //3. addLast()
    public void addLast(T element) {

        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        }
        else {
            Node<T> lastNode = this.getLastNode();
            lastNode.setNext(newNode);
        }
        ++size;
    }

    private Node<T> getLastNode() {
        if (head == null)
            return null;

        Node<T> currentNode = head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    //4. add()
    public void add(int index, T element) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        if (index == 0){
            addFirst(element);
            return;
        }

        if (index == this.size){
            addLast(element);
            return;
        }

        Node<T> current = getNode(index-1);
        Node<T> newNode = new Node<>(element);

        newNode.setNext(current.getNext());
        current.setNext(newNode);
        ++size;
    }

    //5. getFirst()
    public T getFirst() {
        return (head == null) ? null : this.head.getItem();
    }

    //6. getLast()
    public T getLast() {
        return (head == null) ? null : this.getLastNode().getItem();
    }

    //7. get(index)
    public T get(int index) {
        return getNode(index).getItem();
    }

    private Node<T> getNode(int index){
        if (index<0 || index>=this.size)
            throw new IndexOutOfBoundsException();

        if (index==0)
            return this.head;

        Node<T> current = head;
        int counter = 0;

        while (counter < index) {
            current = current.getNext();
            ++counter;
        }

        return current;
    }

    //8. removeFirst()
    public void removeFirst(){
        if (head == null)
            return;

        if (head.getNext() == null){
            head = null;
        }
        else {
            head = head.getNext();
        }
        --size;
    }

    //9. removeLast()
    public void removeLast(){
        if (head == null)
            return;

        if (head.getNext()==null) {
            head = null;
        }
        else {
            Node<T> current = getNode(this.size-2);
            current.setNext(null);
        }
        --size;
    }

    //10. remove(index)
    public void remove(int index){
        if (index<0 || index>=this.size)
            throw new IndexOutOfBoundsException();

        if (index==0) {
            removeFirst();
            return;
        }

        if (index == this.size-1) {
            removeLast();
            return;
        }

        Node<T> current = this.getNode(index-1);
        current.setNext(current.getNext().getNext());
        --size;
    }

    public boolean isEmpty(){
        return head==null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            str.append(current.getItem().toString()).append(" ");
            current = current.getNext();
        }
        return str.toString();
    }
}
