/*You have a long list of tasks that you need to do today. To accomplish task you need M
minutes, and the deadline for this task is D . You need not complete a task at a stretch.
You can complete a part of it, switch to another task, and then switch back.You've
realized that it might not be possible to complete all the tasks by their deadline. So you
decide to do them in such a manner that the maximum amount by which a task's
completion time overshoots its deadline is minimized.
Input Format - The first line contains the number of tasks, . Each of the next
lines contains two integers,D and M .
Output Format - Output T lines. The ith line contains the value of the maximum
amount by which a task's completion time overshoots its deadline, when the first
tasks on your list are scheduled optimally.
*/

package com.datastructure.algorithm.problems;

import java.util.Scanner;

public class Task {
    int[] deadlineArr, timeArr;
    int count;
    public static void main(String[] args) {
        Task task = new Task();
        task.start();
    }
    void start() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of tasks: ");
        count = sc.nextInt();
        deadlineArr = new int[count];
        timeArr = new int[count];

        for(int i = 0; i < count; i++) {
            System.out.print("Enter deadline and time required for the task number :" + (i+1) + " ");;
            deadlineArr[i] = sc.nextInt();
            timeArr[i] = sc.nextInt();
        }
        insertionSortAsc();

        for(int i = 0; i < count; i++) {
            System.out.println("Enter deadline and time required for the task number :" + (i+1) +" ");;
            System.out.println(deadlineArr[i] + "\t");
            System.out.println(timeArr[i]);
            System.out.println();
        }
        printTask();
    }
    void insertionSortAsc() {
        for(int i = 1; i < deadlineArr.length; i++) {
            int deadlineKey = deadlineArr[i];
            int timeKey = timeArr[i];
            int j = i - 1;
            while((j > -1) && (deadlineArr[j] > deadlineKey)) {
                deadlineArr[j+1] = deadlineArr[j];
                timeArr[j+1] = timeArr[j];
                j--;
            }
            deadlineArr[j+1] = deadlineKey;
            timeArr[j+1] = timeKey;
        }
    }
    void printTask() {
        for(int i = 0; i < count; i++) {
            System.out.println("Task " + (i+1) + ":" + timeArr[i]);
        }
    }
}