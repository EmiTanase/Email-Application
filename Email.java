package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailBoxCapacity = 500;
    private int defaultPassordLength = 10;
    private String alternateEmail;
    private String companySuffix = "compay.com";

    //constructor to receive the first name and the last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        //call a method to ask for the department, return -department
        this.department = setDepartment();

        //call a method that returns a random password
        this.password = randomPassword(defaultPassordLength);
        System.out.println("Your password is: " + this.password);

        //combine elements to generate an email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }
    // ask for the department
    private String setDepartment() {
        System.out.println("Department codes: \n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n Enter department code:");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice == 1) {
            return "Sales";
        }
        else if (depChoice == 2) {
            return "Development";
        }
        else if (depChoice == 3) {
            return "Accounting";
        }
        else return "No department selected";
    }
    //generate a random password
    private String randomPassword(int lenght) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVXYZ0123456789!@#$%^&*?";
        char[] password = new char[lenght];
        for (int i = 0; i <lenght; ++i) {
           int rand = (int) (Math.random() * passwordSet.length());
           password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //set the mailbox capacity
    public void setMailBoxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }

    //set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }
    //change password
    public void changePassword (String password) {
        this.password = password;
    }
    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }
    public String getAlternateEmail() {
        return alternateEmail;
    }
    public String getPassword() {
        return password;
    }
    public String showInfo() {
        return "Display name: "+ firstName + " " + lastName + "\nCompany email: " + email + "\nMail box capacity: " + mailBoxCapacity + " MB";
    }
}


