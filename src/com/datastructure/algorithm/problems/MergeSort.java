/*Merge Sort - Write a program to do Merge Sort of list of Strings.
a. Logic -> To Merge Sort an array, we divide it into two halves, sort the two halves
independently, and then merge the results to sort the full array. To sort a[lo, hi),
we use the following recursive strategy:
b. Base case: If the subarray length is 0 or 1, it is already sorted.
c. Reduction step: Otherwise, compute mid = lo + (hi - lo) / 2, recursively sort the
two subarrays a[lo, mid) and a[mid, hi), and merge them to produce a sorted
result.*/
package com.datastructure.algorithm.problems;

public class MergeSort {
    static String[] mergeSort(String[] Arr, int lo, int hi)
    {
        if (lo == hi) {
            String[] A = { Arr[lo] };
            return A;
        }
        int mid = lo + (hi - lo) / 2;
        String[] arr1 = mergeSort(Arr, lo, mid);
        String[] arr2 = mergeSort(Arr, mid + 1, hi);

        String[] arr3 = merge(arr1, arr2);
        return arr3;
    }

    static String[] merge(String[] arr1, String[] arr2)
    {
        int size1 = arr1.length;
        int size2 = arr2.length;
        String[] arr3 = new String[size1 + size2];
        int index = 0;

        int i = 0;
        int j = 0;

        while (i < size1 && j < size2) {
            if (alphabeticalSmaller(arr1[i], arr2[j]))
            {
                arr3[index] = arr1[i];
                i++;
                index++;
            }
            else
            {
                arr3[index] = arr2[j];
                j++;
                index++;
            }
        }
        while (i < size1) {
            arr3[index] = arr1[i];
            i++;
            index++;
        }
        while (j < size2) {
            arr3[index] = arr2[j];
            j++;
            index++;
        }
        return arr3;
    }
    static boolean alphabeticalSmaller(String str1, String str2)
    {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        if (str1.compareTo(str2) < 0)
        {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] arr = { "apple", "mango", "banana", "strawberry" };
        String[] a = mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
