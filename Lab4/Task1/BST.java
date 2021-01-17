/*      Lab4,Assignment1,2,3
        Created:2020-09-24
        Last updated: 2020-09-27
        Author: Amir Ali Safizadeh.
        Purpose of the code: A generic BST that store values with the their given keys. The goal is to compare the
        execution time of the BST with BS
        Credit to Robert Sedgewick and Kevin Wayne who written the book Algorithms. the code in this class is inspired from
        the code in the book.
 */


public class BST<Key extends Comparable<Key>, Value extends Comparable<Value>> {
    // Creating the root
    private Node root;

    // Creating the class node.
    private class Node {
        private Key key;
        private Value value;
        private int n; // Number of the element added.
        // Left and right branches.
        private Node left, right;

        // Node constructor.
        public Node(Key key, Value value, int n) {
            this.value = value;
            this.key = key;
            this.n = n;
            left = null;
            right = null;
        }
    }
    // Return the size of the.
    public int size(){
        return size(root);
    }

    private int size(Node x){
        if(x == null)
            return 0;
        else
            return x.n;
    }

    // Recursive method to put the value and its key to the tree.
    public void put(Key key, Value value){
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        // If the root is empty our node would be that root.
        if (x == null)
            return new Node(key,value,1);
        // Compare the given key to the root key and store it in variable cmp.
        int cmp =key.compareTo(x.key);
        // If cmp is negative, our new node goes to the left branch, And we call put with that node.
        if (cmp < 0 )
            x.left = put(x.left, key, value);
            // If cmp is positive, our new node goes to the right branch. And we call put with that node .
        else if(cmp > 0)
            x.right = put(x.right, key, value);
            // Then it has the same key as root so update the root.
        else x.value = value;

        // update the n
        x.n = size(x.left) + size(x.right) + 1;
        // Return the node
        return x;
    }

    // Check if the key has been already added to the tree.
    public boolean contains(Key key){
        return get(key) !=null;
    }

    // Recursive method to get the value of the given key.
    public Value get(Key key){
        return  get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        // Compare the given key to the root key and store it in variable cmp.
        int cmd = key.compareTo(x.key);
        // If cmp is negative, return the node at the left branch.
        if (cmd < 0 )
            return get(x.left, key);
        // If cmp is positive, return node at the left branch.
        if (cmd > 0)
            return get(x.right, key);
            // Otherwise return the value of x.
        else return x.value;
    }

    // Finding the min and max key.
    public Key min()
    {
        return  min(root).key;
    }
    private Node min(Node x)
    {
        // Searching for min on the left branches.
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key max(){
        return max(root).key;
    }
    private Node max(Node x)
    {
        // Searching for max on the right branches.
        if (x.right == null) return x;
        return max(x.right);
    }

    // Make the keys iterable with the help of our queue class.
    public Iterable<Key> keys()
    { return keys(min(), max()); }
    public Iterable<Key> keys(Key lo, Key hi)
    {
        // Creating the queue.
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi)
    {
        if (x == null) return;
        // compare the min and max key with the root and store it in cmplo and cmphi.
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        // if cmp is negative call the keys again with node on the left branch.
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        // if both true or equal to zero enqueue it.
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        //  if cmp is positive call the keys again with node on the right branch.
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }
}
