/*Insertion Sort
a. Desc -> Reads in strings and prints them in sorted order using insertion sort.
b. I/P -> read in the list words
c. Logic -> Use Insertion Sort to sort the words in the String array
d. O/P -> Print the Sorted List */
package com.datastructure.algorithm.problems;

import java.util.Arrays;

public class InsertionSort {
    void insertionSort(String[] array, int size) {


        for (int step = 1; step < size; step++) {
            String temp = array[step];
            int j = step - 1;
            while (j >= 0 && temp.length()<array[j].length())
            {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    void printArray(String[] str, int size){
        for (int i=0;i<size;i++) {
            System.out.println(str[i] + "");
        }
    }

    public static void main(String[] args) {
        String[] arr = {"one","three","four","hi"};
        int size= arr.length;
        InsertionSort is = new InsertionSort();
        is.insertionSort(arr,size);
        is.printArray(arr,size);
    }
}
