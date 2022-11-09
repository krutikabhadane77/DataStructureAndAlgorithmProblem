/*Palindrome-Checker
a. Desc -> A palindrome is a string that reads the same forward and backward, for
example, radar, toot, and madam. We would like to construct an algorithm to
input a string of characters and check whether it is a palindrome.
b. I/P -> Take a String as an Input
c. Logic -> The solution to this problem will use a deque to store the characters of
the string. We will process the string from left to right and add each character to
the rear of the deque.
d. O/P -> True or False to Show if the String is Palindrome or not.
*/
package com.data.structures.problems;

import java.util.Scanner;

public class PalindromeChecker {
    Deque<Character> deque;
    public static void main(String[] args) {
        PalindromeChecker palChecker=new PalindromeChecker();
        palChecker.deque=new Deque<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string");
        String word=sc.next();
        char[] letters =word.toCharArray();
        for(int i=0;i<letters.length;i++)
        {
            palChecker.deque.addRear(letters[i]);
        }
        System.out.println(palChecker.checkPalindrome());

    }

    private boolean checkPalindrome() {
        boolean isPalindrome=false;
        while(!deque.isEmpty()){
            if(deque.size()!=1)
            {
                if(deque.removeFront().equals(deque.removeRear()))
                {
                    isPalindrome=true;
                }
                else
                {
                    isPalindrome=false;
                    break;
                }
            }
            else
            {
                deque.removeRear();
                isPalindrome=true;
            }
        }
        return isPalindrome;
    }
}
