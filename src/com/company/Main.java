package com.company;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to MH.KALA application");
        Admin admin = new Admin();
        System.out.println();
        admin.show_menu();
    }
}
