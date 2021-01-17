/*      Lab2,Assignment5
        Created:2020-09-15
        Last updated: 2020-09-20
        Author: Amir Ali Safizadeh.
        Purpose of the code: Comparing the execution time for sorting large array of
        integers of insertionsort and mergesort
 */



public class SortTask5 {

    // Constructor
    public SortTask5() {
    }

    // Take the array of integers sort them by going trough all the element and swap them using the swap method if its needed.
    // Print all the elements in the array every time a swap happens, time complexity: b: O(n) w: O(n^2)
    public void insertionSort(int elements[]) {
        for (int i = 1; i < elements.length; i++)
            // Check the neighbouring elements.
            for (int j = i; j > 0 && elements[j] < elements[j - 1]; j--)
                swap(elements, j - 1, j);

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


    // Print all the contents of the array. The print has not been used, implemented for checking if the merge sort works
    // Properly or not
    private void print(int elements []){
        System.out.print("{");
        // Go through the array and print them but not the last element
        for (int i = 0; i<elements.length - 1; i++)
            System.out.print(elements[i] + ", ");
        // Print the last element
        System.out.print(elements[elements.length - 1] + "}");
        System.out.println();
    }

    // Mergesort has two part, one method which is recursively calling itself and splitting the array into half until the length of the sub arrays is less than 2.
    // Other part sort the array and put the sorted element back to the array that we wanted to sort. time complexity: B: O(nlogn) w:O(nlogn), memory complexity:O(n)
    public void mergeSort(int elements[]) {
        // Check if the length of the sub arrays or the original array is less than two.
        if (elements.length < 2) {
            return;
        }
        // Find the middle index
        int mid = (elements.length / 2);

        // create two sub arrays and store the elements of original array into them.
        int tempLeft[] = new int[mid];
        int tempRight[] = new int[elements.length - mid];

        for (int i = 0; i < mid; i++)
            tempLeft[i] = elements[i];

        for (int j = mid; j < elements.length; j++)
            tempRight[j - mid] = elements[j];

        // Calling the mergesort with the sub arrays
        mergeSort(tempLeft);
        mergeSort(tempRight);

        // After all the sub array length are less than 2 we break and we call the merge method to sort the element and merge them together.
        merge(elements, tempLeft, tempRight);

//       print(elements);
    }

    // In this method we sort the sub array and merge then together
    private void merge(int elements[], int left[], int right[]) {

        // Create 3 variables to keep track of the position of the elements
        int leftIndex = 0, rightIndex = 0, elementsIndex = 0;


        while (leftIndex < left.length && rightIndex < right.length) {

            // Check the element on the left if its equal or less than the right element, we put that element
            // in our array and increment the leftIndex.
            if (left[leftIndex] <= right[rightIndex])

                elements[elementsIndex++] = left[leftIndex++];
            // Else we put the right element in our array and increment the rightIndex.
            else
                elements[elementsIndex++] = right[rightIndex++];

            //we do this as long as rightIndex and leftIndex are less than the length of the sub arrays.
        }

            // We check if the left index is less than the length of its sub array. If its true that would mean that there is still
            // elements left in it so we put them in our array as well
            while (leftIndex < left.length)
                elements[elementsIndex++] = left[leftIndex++];
            // We check if the right index is less than the length of its sub array. If its true that would mean that there is still
            // elements left in it so we put them in our array as well
            while (rightIndex < right.length)
                elements[elementsIndex++] = right[rightIndex++];




    }

}
