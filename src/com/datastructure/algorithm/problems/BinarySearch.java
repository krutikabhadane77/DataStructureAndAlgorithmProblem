/*Binary Search the Word from Word List
a. Desc -> Read in a list of words from File. Then prompt the user to enter a word to
search the list. The program reports if the search word is found in the list.
b. I/P -> read in the list words comma separated from a File and then enter the word
to be searched
c. Logic -> Use Arrays to sort the word list and then do the binary search
d. O/P -> Print the result if the word is found or not
*/

package com.datastructure.algorithm.problems;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args)
    {
        String[] strArray = { "one", "two", "three", "four" };
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter word to search");
        String str = sc.next();
        if (binarySearch(strArray, str)) {
            System.out.println("Word  is present");
        }
        else
        {
            System.out.println("Word is not present");
        }

    }
    public static <T extends Comparable<T>> boolean binarySearch(T[] array, T search) {
        int low = 0;
        boolean present = false;
        int high = array.length - 1;
        int mid = high / 2;
        while (high >= low) {
            if (array[mid].compareTo(search) == 0) {
                present = true;
                break;
            }
            if(array[mid].compareTo(search) < 0)
            {
                low = mid + 1;
                mid = (low + high) / 2;
            }
            else {
                high = mid - 1;
                mid = (low + high) / 2;
            }
        }
        return present;
    }

}
