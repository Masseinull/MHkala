package com.company;

import java.util.LinkedList;

class Customer extends Admin{
    String username;
    String password;
    double spent = 0;
    LinkedList<Product> purchased = new LinkedList<Product>();
    LinkedList<Product> in_sent_progress = new LinkedList<Product>();
}
