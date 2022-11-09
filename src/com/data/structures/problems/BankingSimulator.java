/*Simulate Banking Cash Counter
a. Desc -> Create a Program which creates Banking Cash Counter where people
come in to deposit Cash and withdraw Cash. Have an input panel to add people
to Queue to either deposit or withdraw money and dequeue the people. Maintain
the Cash Balance.
b. I/P -> Panel to add People to Queue to Deposit or Withdraw Money and dequeue
c. Logic -> Write a Queue Class to enqueue and dequeue people to either deposit
or withdraw money and maintain the cash balance
d. O/P -> True or False to Show Arithmetic Expression is balanced or not.
*/

package com.data.structures.problems;

import java.util.Scanner;

public class BankingSimulator {
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        Queue<String> queue =new Queue<>();
        int cash=0;
        System.out.println("Enter number of people in line");
        int numberOfPeople=scanner.nextInt();
        addPeople(queue,numberOfPeople);
        while(!queue.isEmpty()){
            while(!queue.isEmpty()){
                String task=queue.dequeue();
                if(task.equals("Withdraw"))
                {
                    cash=withdraw(cash);
                }
                else if(task.equals("Deposite"))
                {
                    cash=deposite(cash);
                }
            }
            System.out.println("how many people added in line?");
            numberOfPeople=scanner.nextInt();
            addPeople(queue,numberOfPeople);
        }
    }

    public static void addPeople(Queue<String> queue,int number){
        int choice;
        int i=0;
        while(i<number){
            System.out.println("Enter task of Person"+(i+1)+" \n1.Withdraw \n2.Deposite");
            choice=scanner.nextInt();
            if(choice==1)
            {
                queue.enqueue("Withdraw");
            }
            else if(choice ==2)
            {
                queue.enqueue("Deposite");
            }
            i++;
        }
    }
    public static int  withdraw(int cash) {
        int amount=0;
        System.out.println("Enter Amount to withdraw : ");
        amount=scanner.nextInt();
        if((cash-amount)>=0){
            cash-=amount;
            System.out.println("Amount debited successfully");
        } else {
            System.out.println("Sorry not enough balance");
        }
        return cash;

    }
    public static int deposite(int cash){
        int amount;
        System.out.println("Enter Amount to deposit : ");
        amount=scanner.nextInt();
        cash+=amount;
        System.out.println("Amount credited successfully");
        return cash;
    }
}
