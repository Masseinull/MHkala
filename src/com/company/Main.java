package com.company;

public class Main {

    public static void main(String[] args) {
	Admin admin = new Admin();
        System.out.println("Hello , welcome to MHKALA application");
        System.out.println("It's your 1st run so you're considered as admin");
        admin.Admin_sign_up();
        System.out.println("Admin created successfully!");
        admin.show_menu();
    }
}
