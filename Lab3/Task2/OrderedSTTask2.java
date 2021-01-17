/*      Lab3,Assignment2
        Created:2020-09-24
        Last updated: 2020-09-26
        Author: Amir Ali Safizadeh.
        Purpose of the code: A generic ordered array ST that store values with the their given keys.
        All the keys store in a odored way(lowest to highest)
        this way, it is easier and faster to find the needed values.
        Credit to Robert Sedgewick and Kevin Wayne who written the book Algorithms. the code in this class is inspired from
        the code in the book.
 */




public class OrderedSTTask2<Key extends Comparable<Key>, Value> {
    // Create two array one for storing our field and other for storing the value of that key
    private Key[] keys;
    private Value[] values;
    // number of the elements inside the arrays
    private int n;

    // Constructor
    public OrderedSTTask2(int capacity){
        // assign the capacity of the arrays
        values = (Value[]) new Object[capacity];
        keys = (Key[]) new Comparable[capacity];
    }

    // For size we simply return n which is the number of elements that have been put in the array
    private int size() {
        return n;
    }

    // If the size is zero return true
    private boolean isEmpty(){
        return size() == 0;
    }

    // Check if the given key is already stored in the ST
    public boolean contains(Key key){
        return get(key) != null;
    }

    // Search for the key and find the position of that key in the array
    public int search(Key key)
    {
        int low = 0, high = n-1;
        // Compare the given key by the key in the middle of our array if there are equal, we found the position and we return mid.
        // If its less than we should check the fist half of the array. if its bigger we should check the other half.
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0)
                // update the high
                high = mid - 1;
            else if (cmp > 0)
                //update the low
                low = mid + 1;
            else return mid;
        }
        // Return the position that the key should be placed
        return low;
    }

    // Take the key and value from the user and find the write spot for them in the array, if the key is already in the
    // update the value of that key to the new value, other wise open a place for the key and value and place them
    // in the arrays
    public void put(Key key, Value value){
        // Calling the search method to find the position of the given key and store it in a variable.
        int i = search(key);
        // Check if the key is already exists in the array, if yes update the value of that key to the new value.
        if (i < n && keys[i].compareTo(key) ==0){
            values[i] = value;
            return;
        }
        // Open the right spot in the array for the value and key.
        for (int j = n ; j > i; j--) {
            keys[j] = keys[j-1]; values[j] = values[j-1];
        }
        // Place them in the array and increase n.
        keys[i] = key; values[i] = value;
        n++;

    }

    // Return the value of the given key. if the key is not in the array return null.
    public Value get(Key key){
        if (isEmpty())
            return null;

        // Find the position of the key by calling the search method
        int i = search(key);
        if (i<n && keys[i].compareTo(key) == 0)
            return values[i];
        return null;
    }

    // Find the first key
    public Key min()
    { return keys[0]; }

    // Find the last key
    public Key max()
    { return keys[n-1]; }

    // Make them Iterable by the help of our queue
    public Iterable<Key> keys(){
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi)
    {
        Queue<Key> queue = new Queue<Key>();
        for (int i = search(lo); i < search(hi); i++)
            queue.enqueue(keys[i]);
        if (contains(hi))
            queue.enqueue(keys[search(hi)]);
        return queue;
    }





}
