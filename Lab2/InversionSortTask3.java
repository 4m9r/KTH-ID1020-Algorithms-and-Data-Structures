/*      Lab2,Assignment3
        Created:2020-09-14
        Last updated: 2020-09-20
        Author: Amir Ali Safizadeh.
        Purpose of the code: Count the number of inversion in the input array
        and print the list of inversion before the array is sorted.
 */


public class InversionSortTask3 {
    // Create a global variable to count the number of inversion
    private int noInversion;

    // Constructor
    public InversionSortTask3(){}

    // Take the array of integers sort them by going trough all the element and swap them using the swap method if its needed.
    // Print all the elements in the array every time a swap happens, time complexity: b: O(n) w: O(n^2)
    public void sort (int elements []) {
        for (int i = 1; i < elements.length; i++)
            // Check the elements by their neighbor.
            for (int j = i; j > 0 && elements[j] < elements[j - 1]; j--) {
                swap(elements, j - 1, j);

                // Print the elements in the array.
                print(elements);
            }
        // Print the final array.
        print(elements);
    }

    // Swap two elements at index1 and index2
    private void swap(int elements[], int index1, int index2) {
        // Create temporary variable to store the value of one element
        int temp;
        temp = elements[index1];
        // Update the value of index1 by referring to element at index2
        elements[index1] = elements[index2];
        // Update elements at index2
        elements[index2] = temp;
    }



    // Print all the contents of the array
    private void print(int elements []) {
        System.out.print("{");
        // Go through the array and print them but not the last element
        for (int i = 0; i < elements.length - 1; i++)
            System.out.print(elements[i] + ", ");
        // Print the last element
        System.out.print(elements[elements.length - 1] + "}");
        System.out.println();


    }

    // Go through the array and find what is the number of inversion and print the element like [i,a[i]], [j, a[j]]
    // where i and j are indices and a[i], a[j] are the values. time complexity is O(n^2)
    public void noOfInversion(int elements []) {
        for (int i = 0; i < elements.length - 1; i++)
            for (int j =i + 1; j < elements.length  ; j++) {
                // if the element needs to swap we increment the number of inversion and print the elements value and their index
                if (elements[j] < elements[i]) {
                       noInversion++;
                       System.out.print("[" + (i) + "," + elements[i] +"]"+ "," +"["+ j + ","
                                + elements[j] + "]");
                       System.out.print("   ");
                }
            }
        // Print the number of inversion in the end and reset it
        System.out.println("number of inversion = " + noInversion);
         noInversion = 0;
        }
}
