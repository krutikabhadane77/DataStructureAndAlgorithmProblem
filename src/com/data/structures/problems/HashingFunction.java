/*Hashing Function to search a Number in a slot
a. Desc -> Create a Slot of 10 to store Chain of Numbers that belong to each Slot to
efficiently search a number from a given set of number
b. I/P -> read a set of numbers from a file and take user input to search a number
c. Logic -> Firstly store the numbers in the Slot. Since there are 10 Numbers divide
each number by 11 and the reminder put in the appropriate slot. Create a Chain
for each Slot to avoid Collision. If a number searched is found then pop it or else
push it. Use Map of Slot Numbers and Ordered LinkedList to solve the problem.
In the Figure Below, you can see number 77/11 reminder is 0 hence sits in the 0
slot while 26/11 remainder is 4 hence sits in slot 4
d. O/P -> Save the numbers in a file
*/
package com.data.structures.problems;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HashingFunction {
    public static void main(String[] args) {
        HashingFunction hash=new HashingFunction();
        Scanner sc=new Scanner(System.in);
        String file="HashFunctionNumbers";
        String number[]=readFile(file);
        HashMap<Integer,LinkedList<Integer>> map=new HashMap<>();
        for(int i=0;i<11;i++){
            map.put(i, new LinkedList<Integer>());
        }
        for(int i=0;i<number.length;i++){
            int  numberToAdd=Integer.parseInt(number[i]);
            map.get(numberToAdd%11).add(numberToAdd);
        }
        System.out.println("Enter number to search");
        int search=sc.nextInt();
        if(hash.findNumber(map,search)){
            System.out.println("Number is present");
            int index=map.get(search%11).index(search);
            map.get(search%11).pop(index);
        }else{
            map.get(search%11).add(search);
            System.out.println("Number Added to the file");
        }
        hash.writeInFile(map, file);
    }
    public boolean findNumber(HashMap<Integer,LinkedList<Integer>> map,int no){
        return map.get(no%11).search(no);
    }
    public static void writeInFile(HashMap<Integer,LinkedList<Integer>> map, String file){
        String nos[]={};
        ArrayList<String> list=new ArrayList<String>();
        for(int i=0;i<map.size();i++){
            int j=0;
            while(j<map.get(i).size()){
                list.add(map.get(i).get(j)+"");
                j++;
            }
        }
        nos=list.toArray(new String[list.size()]);
        writeFile(nos,file);
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
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
