package com.company;

import java.util.LinkedList;
import java.util.Scanner;

public class MHKALA {
    Scanner input = new Scanner(System.in);
    protected LinkedList<String> Products = new LinkedList<String>();
    protected LinkedList<String> Producers = new LinkedList<String>();
    protected LinkedList<String> transporters = new LinkedList<String>();
    protected LinkedList<String> customers = new LinkedList<String>();
    protected String username;
    protected String password;
    protected MHKALA(){
        System.out.print("Please enter a username for yourself: ");
        username = input.nextLine();
        System.out.print("Please enter a password for yourself: ");
        password = input.nextLine();
    }

}
