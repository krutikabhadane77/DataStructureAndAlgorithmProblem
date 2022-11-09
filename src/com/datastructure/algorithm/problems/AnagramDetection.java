/*An Anagram Detection Example
a. Desc -> One string is an anagram of another if the second is simply a
rearrangement of the first. For example, 'heart' and 'earth' are anagrams...
b. I/P -> Take 2 Strings as Input such abcd and dcba and Check for Anagrams
c. O/P -> The Two Strings are Anagram or not....
*/
package com.datastructure.algorithm.problems;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramDetection {
    public static void main(String[] args) {
        String str1, str2;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter two Strings");
        str1 = scanner.nextLine();
        str2 = scanner.nextLine();

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if (String.valueOf(arr1).equals(String.valueOf(arr2))) {
            System.out.println(str1 + " " + str2 + " are anagram");
        } else {
            System.out.println(str1 + " " + str2 + " are not anagram");
        }
    }
}
