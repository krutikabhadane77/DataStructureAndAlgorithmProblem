//Extend the above program to find the prime numbers that are Anagram and Palindrome
package com.datastructure.algorithm.problems;

import java.util.Arrays;

public class PrimeAnagramPalindrome {
    public static void main(String[] args) {
        PrimeAnagramPalindrome p=new PrimeAnagramPalindrome();
        String[] primeNumbers = p.prime(1000);

        System.out.println("Anagram and prime numbers are:");
        for(int i = 0; i < primeNumbers.length; i++) {
            for(int j = i + 1; j < primeNumbers.length; j++) {
                if(p.anagram(primeNumbers[i], primeNumbers[j])) {
                    System.out.println(primeNumbers[i] + " " + primeNumbers[j]);
                }
            }
        }

        System.out.println("\nPalindrome and prime numbers are:");
        for(int i = 0; i < primeNumbers.length; i++) {
            if(p.palindrome(primeNumbers[i])) {
                System.out.println(primeNumbers[i]);
            }
        }

    }
    public String[] prime(int range) {
        String[] array = new String[1000];
        int position = 0;
        for(int i = 2; i <= range; i++) {
            boolean isPrime = true;
            for(int j = 2; j <= i / 2; j++) {
                if((i % j) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                array[position] = String.valueOf(i);
                position++;
            }
        }
        String[] returnArray = new String[position];
        for(int k = 0; k < position; k++) {
            returnArray[k] = array[k];
        }
        return returnArray;
    }

    public boolean palindrome(String string) {
        if(string.length() < 2) {
            return false;
        }
        char[] array = string.toCharArray();
        int n = array.length;
        for(int i = 0; i < n; i++) {
            if(array[i] != array[n - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public boolean anagram(String string1, String string2) {
        if(string1.length() != string2.length()) {
            return false;
        }
        char[] array1 = string1.toCharArray();
        Arrays.sort(array1);
        char[] array2 = string2.toCharArray();
        Arrays.sort(array2);

        for(int i = 0; i < array1.length; i++) {
            if(array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }
}
