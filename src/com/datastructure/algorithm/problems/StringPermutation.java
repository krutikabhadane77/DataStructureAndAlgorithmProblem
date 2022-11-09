/*Write static functions to return all permutations of a String using iterative method and
Recursion method. Check if the arrays returned by two string functions are equal.*/
package com.datastructure.algorithm.problems;

import java.util.Scanner;

public class StringPermutation {

    public static void stringPermute(String first, String last) {
        int size = last.length();
        if (size == 0) {
            System.out.println(first);
        } else {
            for (int i = 0; i < size; i++) {
                String myFirst = first + last.charAt(i);
                String myLast = last.substring(0, i) + last.substring(i + 1 , size);
                stringPermute(myFirst, myLast);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string to find the permutations: ");
        String stringToPermute = sc.next();
        stringPermute("", stringToPermute);
    }
}
