
/*      Lab3,Assignment4
        Created:2020-09-25
        Last updated: 2020-09-27
        Author: Amir Ali Safizadeh.
        Purpose of the code: Find the position of the Word and list all occurrences of the that
        word.
 */



import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PositionTask4 {

    // This method Get a text and a word and find all the positions of that word in the text and store them in an array list.
    public static List<Integer> finder(String text, String key) {
        List<Integer> list = new ArrayList<>();
        // Storing the given word in a string variable between of 2 space to avoid counting other words
        // example: the their
        String word =  " " + key + " ";
        int i = 0;
        // If there is the word we are looking for in the text we store the index of that word in our list
        while (i != -1) {
            // Start from index i looking for our word and if it finds it it return the index of that word we store that
            // in i, if it never occurs, it returns -1.
            i = text.indexOf(word, i);
            if (i != -1) {
                list.add(i);
                // update the i to don't count one word twice
                i++;
            }

        }
        return list;
    }








    public static void main(String[] args) throws FileNotFoundException {
        // Store our file.
        File file = new File("C:\\Users\\\\Desktop\\text.txt");
        // Using the scanner method to read file and put it into the hash table.
        Scanner scanner = new Scanner(file);
        // Using scanner to type the word that we want to find its position.
        Scanner input = new Scanner(System.in);
        String text = "";
        String word;
        // Storing all the word in the file as a big string.
        while (scanner.hasNext()) {
            word = scanner.nextLine();
            text = text + " " + word + " ";
        }

        System.out.println("type the word :");
        String key = input.next();
        // Sore the return list from the word finder in the a new list.
        List<Integer> list = finder(text,key);

        // If our list is empty return no word has been found.
        if (list.isEmpty())
            System.out.println("no word has been found");
        else {
            // The size of the list is the word frequency in the text.
            System.out.println("frequency of word : " + list.size());
            // Print all the element of the list.
            for (int i = 0; i < list.size(); i++)
                System.out.println(list.get(i));
        }

    }


}
