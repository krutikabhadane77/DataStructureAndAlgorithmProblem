/*Question to find your number
a. Desc -> takes a command-line argument N, asks you to think of a number
between 0 and N-1, where N = 2^n, and always guesses the answer with n
questions.
b. I/P -> the Number N and then recursively ask true/false if the number is between
a high and low value
c. Logic -> Use Binary Search to find the number
d. O/P -> Print the intermediary number and the final answer
*/
package com.datastructure.algorithm.problems;

import java.util.Scanner;

public class FindNumber {

    public static void main(String[] args) {
        int range=Integer.parseInt(args[0]);
        System.out.println("Think  number between 0 to "+(range));
        findNumber(0, range);
    }
    public static void findNumber(int first, int last) {
        int middle = (first + last) / 2;
        if (first < last) {
            System.out.println("Is your number between " + first + " and " + middle + " [y/n]:");
            Scanner sc = new Scanner(System.in);
            char choice = sc.next().charAt(0);
            if (choice == 'y' || choice == 'Y') {
                findNumber(first, middle);

            } else {
                findNumber(middle + 1, last);
            }
        } else if (first == last) {
            System.out.println("Number is " + last);
        }
    }
}
