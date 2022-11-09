package com.datastructure.algorithm.problems;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class StringReplace {
    private String firstName;
    private String lastName;
    private String mobileNo;
    private String date;
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String date() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return formatter.format(date);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringReplace stringReplace = new StringReplace();

        String name = "<<name>>";
        String fullname = "<<full name>> ";
        String mobile = "xxxxxxxxxx";
        String date = "12/06/2016";

        System.out.println();
        System.out.println("Enter FirstName:");
        stringReplace.setFirstName(sc.next());
        System.out.println();

        System.out.println("Enter LastName:");
        stringReplace.setLastName(sc.next());
        System.out.println();

        System.out.println("Enter Mobile Number:");
        stringReplace.setMobileNo(sc.next());
        System.out.println();

        //Setting current date
        stringReplace.setDate(stringReplace.date());

        System.out.println(convertString(stringReplace,name));
        System.out.println(convertString(stringReplace,fullname));
        System.out.println(convertString(stringReplace,mobile));
        System.out.println(convertString(stringReplace,date));

    }
    public static String convertString(StringReplace userDetails, String message){
        Pattern p = Pattern.compile("<<name>>");
        Matcher m = p.matcher(message);
        message = m.replaceAll(userDetails.getFirstName());

        p = Pattern.compile("<<full name>>");
        m = p.matcher(message);
        message = m.replaceAll(userDetails.getFirstName()+" "+userDetails.getLastName());

        p = Pattern.compile("xxxxxxxxxx");
        m = p.matcher(message);
        message = m.replaceAll(userDetails.getMobileNo());

        p = Pattern.compile("01/01/2016");
        m = p.matcher(message);
        message = m.replaceAll(userDetails.getDate());

        return message;
    }
}
