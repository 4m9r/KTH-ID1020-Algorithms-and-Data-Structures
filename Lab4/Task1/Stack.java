/*      Lab4,Assignment1, 2, 3
        Created:2020-10-01
        Last updated: 2020-10-02
        Author: Amir Ali Safizadeh.
        Purpose of the code: A generic iterable Stack(LIFO) to store object in. It has push and pop method to put and get the
        elements in and out of the stack.
 */




import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
    // The head of the stack
    private Node<Item> head;
    // number of element put in the stack
    private int counter;

    // Node class that contains value and the next node in it.
    private class Node<Item>{
      private Item item;
      private Node<Item> next;
      // Node constructor with item as value to avoid empty nodes
      public Node(Item item){
          this.item = item;

      }

    }
    // Constructor of the Stack, update counter and the head.
    public Stack(){
        head = null;
        counter = 0;
    }

    // Check if the stack is empty or not
    public boolean isEmpty(){
        return head == null;
    }

    // Return the number of elements in the stack
    public int size(){
        return counter;
    }

    // Put the given element into the stack
    public void push(Item item){
        // Store the current head
        Node<Item> oldHead = head;
        // Create a node object for the new head and set the given value into it
        head = new Node<Item>(item);
        // Connect the new head to the old one
        head.next = oldHead;
        // Update the number of elements in the stack
        counter++;
    }

    // Pop out the first element in the stack
    public Item pop(){
        // Check that the stack is not empty
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        // Save the value which stored in the head
        Item item = head.item;
        // Update the head
        head = head.next;
        // Update the number of the elements in the stack
        counter--;
        // Return the first element's value
        return item;
    }


    // Make the stack iterable
    public Iterator<Item> iterator() {
        return new LinkedIterator(head);
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }


}
