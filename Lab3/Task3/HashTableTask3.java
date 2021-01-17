/*      Lab3,Assignment3
        Created:2020-09-25
        Last updated: 2020-09-27
        Author: Amir Ali Safizadeh.
        Purpose of the code: A generic Hash table to see how evenly the built in hash function
        for string in java distributes the hashes for the words found in the text.
        Credit to Robert Sedgewick and Kevin Wayne who written the book Algorithms. the code in this class is inspired from
        the code in the book.
 */


public class HashTableTask3<Key, Value> {

    private int m; // The size of the hash table.
    private Node[] list; // Creating an array of nodes.


    // The node class containing the value, key and next node.
    private static class Node{
        private Object value;
        private Object key;
        private Node next;

        // Constructor for the class node.
        public Node(Object key,Object value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    // Using m the size of the hash table we assign the length of the hash table.
    public HashTableTask3() {
        this(997);
    }

    public HashTableTask3(int m) {

        this.m = m;
        list = new Node[m];

    }

    // Finding the hash value of the given key, This method will return an index that we can use for the node array.
    private int hashing(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    // Put the given key and value in the correct position by finding the hash value of that key.
    public void put(Key key, Value value){
        // If the value is null we do not store it and we simply return.
        if (value == null)
            return;

        // Calculating the hash value of the key by calling the hash method.
        int i = hashing(key);

        // Go through the nodes in the element that has index i which we found with the help of hash code,
        // to check if the key is already stored in the hash table.
        for (Node temp = list[i]; temp != null; temp = temp.next) {
            // if the key is already in the hash table we update the value of that key to the new given value.
           if(key.equals(temp.key)) {
               temp.value = value;
               return;
           }
        }
        // Otherwise we create a new node and store the given key and value in it.
        list[i] = new Node(key, value, list[i]);

    }

    // Return the value of the given key if key was nof found it would return null.
    public Value get(Key key){
        // Find the hash value of the key and store it in the i.
        int i = hashing(key);
       // Go through the nodes in the element that has index i which we found with the help of hash code,
        // if the is found, return its value otherwise return null.
        for (Node temp = list[i]; temp != null; temp = temp.next) {
            if(temp.key.equals(key));
                return (Value) temp.value;
        }
        return null;
    }
    // Make keys Iterable
    public Iterable<Key> keys() {

        Queue<Key> queue = new Queue<Key>();

        for (int i = 0; i < m; i++) {
            for (Node x = list[i]; x != null; x = x.next) {

                queue.enqueue((Key) x.key);
            }
        }
        return queue;
    }

    // Print the number of the node in each element to see how evenly spread they are.
    public void show(){
        int counter =0;
        // Go through the array.
        for (int i = 0; i < list.length; i ++) {
            // Count the nodes.
            for (Node temp = list[i]; temp != null; temp = temp.next)
                counter++;

            System.out.println(counter);
            counter =0;

        }
    }
}
