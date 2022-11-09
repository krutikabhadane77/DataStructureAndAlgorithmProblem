/*Simple Balanced Parentheses
a. Desc -> Take an Arithmetic Expression such as
(5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3) where parentheses are used to order the
performance of operations. Ensure parentheses must appear in a balanced
fashion.
b. I/P -> read in Arithmetic Expression such as (5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3)
c. Logic -> Write a Stack Class to push open parenthesis “(“ and pop closed
parenthesis “)”. At the End of the Expression if the Stack is Empty then the
Arithmetic Expression is Balanced. Stack Class Methods are Stack(), push(),
pop(), peak(), isEmpty(), size()
d. O/P -> True or False to Show Arithmetic Expression is balanced or not.
*/
package com.data.structures.problems;

import java.util.Scanner;

public class BalanceParentheses {

    public static void main(String[] args) {
        Stack<Character> parenthesesSatck = new Stack<Character>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter equation to check balanced or not : ");
        String equation = sc.nextLine();

        char[] equationCharcaterArray = equation.toCharArray();
        for (char character : equationCharcaterArray) {
            if (character == '(')
            {
                parenthesesSatck.push(character);
            }
            else if (character == ')')
            {
                if (parenthesesSatck.isEmpty())
                {
                    System.out.println("Equation is balanced.");
                    return;
                }
                else
                {
                    parenthesesSatck.pop();
                }
            }
        }

        if (parenthesesSatck.isEmpty())
        {
            System.out.println("Equation is balanced.");
        }
        else
        {
            System.out.println("Enquation is not balanced.");
        }
    }
}
