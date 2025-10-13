package com.company;

import java.util.LinkedList;

class Producer extends Admin{
    protected String username;
    protected String password;
    double income = 0;
    int current_producer = 0;
    LinkedList<Product> current_producer_products = new LinkedList<Product>();
    LinkedList<Product> sold_products_by_current_producer = new LinkedList<Product>();
}