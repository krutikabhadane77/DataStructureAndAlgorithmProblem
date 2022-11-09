/*12.Write a program Calendar.java that takes the month and year as command-line
arguments and prints the Calendar of the month. Store the Calendar in an 2D Array,
the first dimension the week of the month and the second dimension stores the day
of the week.
*/
package com.data.structures.problems;

public class Calender {
    public static int day(int month, int day, int year) {
        int y = year - (14 - month) / 12;
        int x = y + y/4 - y/100 + y/400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        return (day + x + (31*m)/12) % 7;
    }
    public static boolean checkLeap(int year) {
        if  ((year % 4 == 0) && (year % 100 != 0))
            return true;
        return year % 400 == 0;
    }


    public static void main(String[] args) {
        int month = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);
        String[] months = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && checkLeap(year)) days[month] = 29;
        System.out.println("   " + months[month] + " " + year);
        System.out.println(" S  M Tu  W Th  F  S");
        int d = day(month, 1, year);
        for (int i = 0; i < d; i++)
            System.out.println();
        for (int i = 1; i <= days[month]; i++) {
            System.out.printf("%2d ", i);
            if (((i + d) % 7 == 0) || (i == days[month])) System.out.println();
        }
    }
}

