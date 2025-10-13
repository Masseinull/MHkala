package com.company;

import java.util.LinkedList;

class Transporter extends Admin{
    String username;
    String password;
    Vehicle current_veichle;
    double transsported_volume = 0;
    LinkedList<Product> Current_transporter_in_progress = new LinkedList<Product>();
    LinkedList<Product> Current_transporter_sent = new LinkedList<Product>();
}
