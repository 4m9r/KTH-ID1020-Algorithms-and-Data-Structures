/*      Lab4,Assignment1, 2, 3
        Created:2020-09-24
        Last updated: 2020-09-26
        Author: Amir Ali Safizadeh.
        Purpose of the code: A generic iterable Queue(FIFO) to store object in. It has enqueue and dequeue method to put and get the
        elements in and out of the stack.
 */



import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue <Item> implements Iterable<Item> {
    // Creating to node for the end and the start of the queue
    private Node<Item> head;
    private Node<Item> tail;
    private int counter;

    // Crating the node class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    // Queue constructor, update the tail and head to null.
    public Queue() {
        head = null;
        tail = null;
    }

    // If the array is empty (the head is empty) this method will return true
    public boolean isEmpty() {

        return head == null;
    }

    // Enqueue an element into the queue
    public void enqueue(Item item) {
        // Create a temp node value to store the tail
        Node<Item> temp = tail;
        tail = new Node<Item>();
        // Enqueuing the given value into tail
        tail.item = item;
        tail.next = null;
        // if the queue is empty update the head and tail otherwise connect the temp(previous tail) to our new tail
        if (isEmpty())
            head = tail;
        else
            temp.next = tail;

        counter++;
    }

    public Item dequeue(){
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        Item item = head.item;
        head = head.next;
        counter--;
        return item;

    }

    public int size(){
        return counter;
    }


    // Make the list iterable
    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(head);
    }
    // Use the already implemented ListIterator from java.util
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> head) {

            current = head;
        }

        public boolean hasNext(){

            return current != null;
        }


        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
