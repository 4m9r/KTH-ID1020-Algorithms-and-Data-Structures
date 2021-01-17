/*      Lab2,Assignment1
        Created:2020-09-13
        Last updated: 2020-09-20
        Author: Amir Ali Safizadeh.
        Purpose of the code: Insertion sorting. Sort all the contents of the array(integers)
        and after each inner loop the contents of the array will be printed.
 */


public class InsertionSortTask1 {


    // Constructor
    public InsertionSortTask1(){}

    // Take the array of integers sort them by going trough all the element and swap them using the swap method if its needed.
    // Print all the elements in the array every time a swap happens, time complexity: b: O(n) w: O(n^2)
    public void sort (int elements []) {
        for (int i = 1; i < elements.length; i++)
            // Check the neighbouring elements.
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
    private void print(int elements []){
        System.out.print("{");
        // Go through the array and print them but not the last element
        for (int i = 0; i<elements.length - 1; i++)
            System.out.print(elements[i] + ", ");
        // Print the last element
        System.out.print(elements[elements.length - 1] + "}");
        System.out.println();
    }


}
