/*Bubble Sort
a. Desc -> Reads in integers prints them in sorted order using Bubble Sort
b. I/P -> read in the list ints
c. O/P -> Print the Sorted List
package com.datastructure.algorithm.problems;
*/
package com.datastructure.algorithm.problems;
import java.util.Arrays;

public class BubbleSort {
    private static int[] array;

    public static <T extends Comparable<T>> int bubbleSort(int[] array) {
        BubbleSort.array = array;
        int size = array.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return size;
    }
    public static void main(String[] args) {
        int[] data = { 12,9,11,4,3,7,2 };
        BubbleSort.bubbleSort(data);
        System.out.println("Sorted Array :");
        System.out.println(Arrays.toString(data));
    }
}
