package com.company;

import java.util.Scanner;

public class Admin extends MHKALA{
    Scanner input = new Scanner(System.in);
    public void Admin_sign_in(){
        System.out.println("Admin Please enter your username");
        String user;
        String pass;
        do {
        user = input.next();
        if (user.equalsIgnoreCase(username)){
            break;
        }else {
            System.out.println("Not admin!");
        }
        }while (!user.equalsIgnoreCase(username));
        System.out.println("ADMIN Please enter your password");
        do {
        pass = input.next();
        if (pass.equalsIgnoreCase(password)){
            System.out.println("Admin Signed-in Successfully");
        }else {
            System.out.println("TRY AGAIN!");
        }
        }while (!pass.equalsIgnoreCase(password));
    }
    public void admin_options(){
        System.out.println("What do you want to do as admin?");
        System.out.println("1-add producer  2-add transporter  3-set sales  4-view statistics  5-logout ");
        byte choice;
        do {
            choice = input.nextByte();
            switch (choice){
                case 1: addProducer(Producers.size());
            }
        }while (choice > 0 && choice < 6);
    }
    public void addProducer(int producer_number){
        Producer p = new Producer("Producer"+producer_number,"p"+producer_number);
    }
    public void show_menu(){
        System.out.println("Please Choose Your Account Type");
        System.out.println("1.Admin  2.Producer  3.Transporter  4.Customer");
        boolean admin_menu = false;
        boolean producer_menu = false;
        boolean transporter_menu = false;
        boolean customer_menu = false;
        byte choice_1;
        do {
            choice_1 = input.nextByte();
            switch (choice_1) {
                case 1:
                    admin_menu = true;
                    break;
                case 2:
                    producer_menu = true;
                    break;
                case 3:
                    transporter_menu = true;
                    break;
                case 4:
                    customer_menu = true;
                    break;
                default:
                    System.out.print("Try again! ");
                    break;
            }
        } while (choice_1 < 1 || choice_1 > 4);
        if (admin_menu){
            System.out.println("You want to enter as admin");
            Admin_sign_in();
            admin_options();
        }

    }
}
