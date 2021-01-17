/*      Lab4,Assignment1, 2, 3
        Created:2020-10-01
        Last updated: 2020-10-02
        Author: Amir Ali Safizadeh.
        Purpose of the code: A generic iterable Bag
 */


import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
    // The head of the bag
    Node<Item> head;

    // Construct the bag, update the head to null
    public Bag(){
        head = null;

    }

    // Node class that contains value and the next node in it.
    private static class Node<Item>{
        Item value;
        Node<Item> next;
    }

    // Add one element to the bag
    public void add(Item value){
            // Store the current head to use its next
            Node<Item> oldHead = head;
            // Create a node object for our new head and set the given value into it
            head = new Node<Item>();
            head.value =value;
            // Connect the new head to our old head
            head.next = oldHead;

    }

    // Make the bag iterable
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>
    {
        private Node<Item> current = head;
        public boolean hasNext()
        { return current != null; }
        public Item next()
        {
            Item item = current.value;
            current = current.next;
            return item;
        }
    }

}
