/*Number of Binary Search Tree
Solve the Problem in the following link
https://www.hackerrank.com/challenges/number-of-binary-search-tree.
*/
package com.data.structures.problems;

import java.util.Scanner;

public class BinarySearchTree {
    public static int treeCount(int number) {
        int intSum = 0;
        if (number == 0 || number == 1) {
            return 1;
        } else if (number == 2) {
            return 2;
        } else {
            for (int i = 0; i < number; i++) {
                intSum = intSum + treeCount(i) * treeCount(number - i - 1);
            }
            return intSum;
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of test cases: ");
        int n = sc.nextInt();
        System.out.println(treeCount(n)+" binary search trees are possible" );
    }
}
