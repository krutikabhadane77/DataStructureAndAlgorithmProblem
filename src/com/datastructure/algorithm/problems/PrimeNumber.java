//Take a range of 0 - 1000 Numbers and find the Prime numbers in that range.
package com.datastructure.algorithm.problems;

public class PrimeNumber {
    public static int isPrime(int n) {
       for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return -1;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int lower_bound = 2, upper_bound = 50;

        for (int i = lower_bound; i <= upper_bound; i++) {
            if (isPrime(i) == 1) {
                System.out.println(i + " ");
            }
        }
    }
}