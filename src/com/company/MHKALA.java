package com.company;

import java.util.LinkedList;
import java.util.Scanner;

public class MHKALA {
    Scanner input = new Scanner(System.in);
    protected LinkedList<Product> Products = new LinkedList<Product>();
    protected LinkedList<Producer> Producers_info = new LinkedList<Producer>();
    protected LinkedList<String> Producers = new LinkedList<String>();
    protected LinkedList<String> Producers_password = new LinkedList<String>();
    protected LinkedList<Transporter> Transporters_info = new LinkedList<Transporter>();
    protected LinkedList<String> Transporters = new LinkedList<String>();
    protected LinkedList<String> Transporters_password = new LinkedList<String>();
    protected LinkedList<Product> all_purchases = new LinkedList<Product>();
    protected LinkedList<Product> Should_be_sent = new LinkedList<Product>();
    protected LinkedList<Product> in_progress = new LinkedList<Product>();
    protected LinkedList<Product> sent = new LinkedList<Product>();
    protected LinkedList<String> Customers = new LinkedList<String>();
    protected LinkedList<Customer> Customers_info = new LinkedList<Customer>();
    protected String username;//admin
    protected String password;//admin
    protected MHKALA(){}

}
