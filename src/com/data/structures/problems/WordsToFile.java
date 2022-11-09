/*UnOrdered List
a. Desc -> Read the Text from a file, split it into words and arrange it as Linked List.
Take a user input to search a Word in the List. If the Word is not found then add it
to the list, and if it found then remove the word from the List. In the end save the
list into a file
b. I/P -> Read from file the list of Words and take user input to search a Text
c. Logic -> Create a Unordered Linked List. The Basic Building Block is the Node
Object. Each node object must hold at least two pieces of information. One ref to
the data field and second the ref to the next node object.
d. O/P -> The List of Words to a File.
*/
package com.data.structures.problems;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WordsToFile {
    public static void main(String[] args) {
        String file="UnorderedListWords";
        String words[]=readFile(file);
        UnorderedList<String> linklist=new UnorderedList<>();
        for(int i=0;i<words.length;i++){
            linklist.add(words[i]);
        }
        linklist.printList();
        System.out.println("Enter word to search");
        Scanner scanner=new Scanner(System.in);
        String search=scanner.next();


        if(linklist.search(search)){
            System.out.println("Word is already present in linked list");
        }else {
            appendFile(search,file);
            System.out.println("Word Added to list");
        }
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

    public static void appendFile(String word, String filePath) {

        try {
            FileWriter writer = new FileWriter(filePath, true);
            PrintWriter out = new PrintWriter(writer);
            out.println(word);
            out.close();
            writer.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

