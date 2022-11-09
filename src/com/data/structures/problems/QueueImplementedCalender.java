/*13.Create the Week Object having a list of WeekDay objects each storing the day (i.e
S,M,T,W,Th,..) and the Date (1,2,3..) . The WeekDay objects are stored in a Queue
implemented using Linked List. Further maintain also a Week Object in a Queue to
finally display the Calendar

14.Modify the above program to store the Queue in two Stacks. Stack here is also
implemented using Linked List and not from Collection Library
*/
package com.data.structures.problems;

import java.util.Scanner;

public class QueueImplementedCalender {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String[] daysOfWeek ={ "S", "M", "T", "W", "Th", "F", "Sa" };
        Queue weekQueue=new Queue<>();
        Stack weekStack=new Stack();
        Stack monthStack=new Stack();
        Queue week;
        System.out.println("Enter month and year");
        int month=scanner.nextInt();
        int year=scanner.nextInt();
        String[][] calender =new String[7][7];
        fillArray(calender, month, year);
        for(int i=1;i<calender.length;i++){
            week =new Queue<WeekDay>();
            for(int j=0;j<calender[i].length;j++){
                WeekDay day=new WeekDay();
                day.date=calender[i][j];
                day.day=daysOfWeek[j];
                week.enqueue(day);
            }
            weekQueue.enqueue(week);
            weekStack.push(week);
        }
        monthStack.push(weekQueue);
        displayQueue(weekQueue);
    }

    public static int dayOfWeek(int day, int month, int year) {
        int m0, y0, d0, x;
        y0 = year - (14 - month) / month;
        x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        m0 = month + 12 * ((14 - month) / 12) - 2;
        d0 = (day + x + (31 * m0) / 12) % 7;
        return d0;
    }

    public static void fillArray(String[][] days, int month, int year) {
        int daysInMonth[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int dayCount = 1;
        String weekDays[] = { "S", "M", "T", "W", "Th", "F", "Sa" };
        int startDay = dayOfWeek(1, month, year);
        int j = 0;
        if (checkLeap(year)) {
            daysInMonth[2] = 29;
        }
        for (int i = 0; i < 7; i++) {
            days[j][i] = weekDays[i];
        }

        for (int i = 1; i < 7; i++) {
            for (j = 0; j < 7; j++)
                if (startDay >= dayCount) {
                    days[i][j] = " ";
                    startDay--;

                } else if (dayCount <= daysInMonth[month]) {
                    days[i][j] = String.valueOf(dayCount);
                    dayCount++;
                } else {
                    days[i][j] = " ";
                }
        }
    }

    public static boolean checkLeap(int year) {
        boolean isLeapYear;
        isLeapYear = (year % 4 == 0);
        isLeapYear = isLeapYear && (year % 100) != 0;
        isLeapYear = isLeapYear || (year % 400) == 0;
        return isLeapYear;

    }
    private static void displayQueue(Queue weekQueue) {
        String[] daysOfWeek ={ "S", "M", "T", "W", "Th", "F", "Sa" };
        for (String s : daysOfWeek) {
            System.out.print(s + "\t");
        }
        System.out.println();
        int weekQueueSize=weekQueue.size();
        for(int i=0;i<weekQueueSize;i++){
            Queue week =(Queue) weekQueue.dequeue();
            int weekSize=week.size();
            for(int j=0;j<weekSize;j++){
                WeekDay day=(WeekDay) week.dequeue();
                System.out.print(day.date+"\t");
            }
            System.out.println();
        }
    }
}
