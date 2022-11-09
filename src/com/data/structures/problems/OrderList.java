/*Ordered List
a. Desc -> Read .a List of Numbers from a file and arrange it ascending Order in a
Linked List. Take user input for a number, if found then pop the number out of the
list else insert the number in appropriate position
b. I/P -> Read from file the list of Numbers and take user input for a new number
c. Logic -> Create a Ordered Linked List having Numbers in ascending order.
d. O/P -> The List of Numbers to a File.
*/
package com.data.structures.problems;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
class OrderedList<T extends Comparable<T>> extends LinkedList<T> {
    @Override
    public void add(T data) {
        Node<T> tempCurrent = root;
        Node<T> tempPrev = root;
        Node<T> newNode = new Node<T>(data);
        if (this.isEmpty()) {
            root = newNode;
            end = root;
        } else if (root.data.compareTo(data) > 0) {
            newNode.next = root;
            root = newNode;
        } else if (end.data.compareTo(data) < 0) {
            end.next = newNode;
            newNode.next = null;
            end=newNode;
        } else {
            while (tempCurrent != null) {
                if (tempCurrent.data.compareTo(data) > 0) {
                    newNode.next = tempPrev.next;
                    tempPrev.next = newNode;
                    break;
                }
                tempPrev=tempCurrent;
                tempCurrent=tempCurrent.next;
            }
        }
    }
}
public class OrderList {
    public static void main(String args[]){
        String file="OrderedList";
        String num[]=readFile(file);

        OrderedList<Integer> list=new OrderedList<Integer>();
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<num.length;i++){
            System.out.println(num[i]);
            list.add(Integer.parseInt(num[i]));
        }
        System.out.println("Enter number to search");
        int numSearch=sc.nextInt();
        if(list.search(numSearch)){
            System.out.println("Number is present");
            list.remove(numSearch);
        } else {
            System.out.println("Number added");
            list.add(numSearch);
        }

        num=new String[list.size()];
        for(int i=0;i<list.size();i++){
            num[i]=String.valueOf(list.get(i));
            System.out.println(num[i]);
        }
        writeFile(num, file);
    }


    public static String[] readFile(String filePath) {
        String words[] = {};
        ArrayList<String> lines = new ArrayList<String>();
        String line, temp[] = {};
        BufferedReader bufferedReader;
        FileReader file;
        int index = 0;
        try {
            file = new FileReader(filePath);
            bufferedReader = new BufferedReader(file);
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",|\\s");
                for (int i = 0; i < temp.length; i++) {
                    lines.add(temp[i]);

                }
            }
            words = lines.toArray(new String[lines.size()]);
            bufferedReader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return words;
    }

    public static void writeFile(String word[], String filePath) {

        try {
            FileWriter writer = new FileWriter(filePath, false);
            PrintWriter out = new PrintWriter(writer);
            for (int i = 0; i < word.length; i++) {
                out.write(word[i] + " ");
            }
            out.close();
            writer.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
