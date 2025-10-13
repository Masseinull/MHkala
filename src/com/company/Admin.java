package com.company;

import java.util.LinkedList;
import java.util.Scanner;

public class Admin extends MHKALA{
    int current_producer = 0;
    int current_transporter = 0;
    int current_customer = 0;
    double sale_percent = 0;
    Scanner input = new Scanner(System.in);
    //////////////
    /*admin things*/
    public void Admin_sign_up(){
        System.out.print("1st please set a username for yourself admin:");
        this.username = input.next();
        System.out.println("your username is "+this.username);
        System.out.print("1st please set a password for yourself admin:");
        this.password = input.next();
        System.out.println("your password is "+this.password);
    }
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
                case 1: addProducer();break;
                case 2: addTransporter();break;
                case 3: admin_set_sales();break;
                case 4: statistics_menu();break;
                case 5: show_menu();return;
            }
        }while (!(choice > 0 && choice < 6));
        return;
    }
    public void addProducer(){
        Producer p = new Producer();
        System.out.print("set the producer's username: ");
        do {
            p.username = input.next();
            if(Producers.contains(p.username)){
                System.out.println("this username is already taken,Please set another one ");
            }
        } while (Producers.contains(p.username));
        Producers.add(p.username);
        System.out.print("set the producer's password: ");
        p.password = input.next();
        Producers_password.add(p.password);
        Producers_info.add(p);
        admin_options();
    }
    public void addTransporter(){
        Transporter t = new Transporter();
        System.out.print("set the transporter's username: ");
        do {
            t.username = input.next();
            if(Transporters.contains(t.username)){
                System.out.println("this username is already taken,Please set another one ");
            }
        } while (Transporters.contains(t.username));
        Transporters.add(t.username);
        System.out.print("set the transporter's password: ");
        t.password = input.next();
        Transporters_password.add(t.password);
        System.out.print("set the transporter's Vehicle: ");
        System.out.println("1-MotorCycle  2-Car  3-Truck");
        byte choice;
        do {
            choice = input.nextByte();
            switch (choice){
                case 1: t.current_veichle = new MotorCycle();break;
                case 2: t.current_veichle = new Car();break;
                case 3: t.current_veichle = new Truck();break;
                default: System.out.println("Your choice should be 1,2 or 3");
            }

        }while (choice < 1 || choice > 3);
        Transporters_info.add(t);
        admin_options();
    }
    public void admin_set_sales(){
        System.out.print("How many percent sales do you want to apply? ");
        sale_percent = input.nextDouble();
        if(sale_percent > 0 && sale_percent < 101 && !Products.isEmpty()) {
            for (int i = 0; i < Products.size(); i++) {
                Products.get(i).price -= (Products.get(i).price * sale_percent / 100);
            }
        }else {
            System.out.println("2 possible errors:");
            System.out.println("1- The entry sale percent should be a number beetween 0 and 100");
            System.out.println("2- no products added");
        }
            admin_options();
    }
    public void statistics_menu(){
        System.out.println("Which one do you want to see? ");
        System.out.println("1-producer's incomes   2-customer's spent money  3-transporter's transported volume");
        System.out.println("4-producer's sold products   5-customer's purchases  6-transporter's transported products");
        System.out.println("                                 7-home");
        int choice;
        do {
            choice = input.nextInt();
            switch (choice){
                case 1: show_income();statistics_menu();break;
                case 2: show_spent();statistics_menu();break;
                case 3: show_volume();statistics_menu();break;
                case 4: show_sold_for_admin();statistics_menu();break;
                case 5: show_purchased_for_admin();statistics_menu();break;
                case 6: show_transported_for_admin();statistics_menu();break;
                case 7: admin_options();return;
                default: System.out.println("Your choice should be 1,2,3,4,5,6 or 7");
            }
        }while (choice<1 || choice>7);
    }
    ///////////////
    /*Producer things*/
    public void Producer_sign_in(){
        System.out.print("Please enter your username: ");
        String user;
        String pass;
        do {
            user = input.next();
            if (!Producers.contains(user)){
                System.out.println("We don't have a producer with this username");
            }
        }while (!Producers.contains(user));
        System.out.print("Please enter your password: ");
        do {
            pass = input.next();
            if(!pass.equalsIgnoreCase(Producers_password.get(Producers.indexOf(user)))){
                System.out.println("WRONG PASSWORD!! TRY AGAIN!");
            }
        }while (!Producers_info.get(Producers.indexOf(user)).password.equals(pass));
        current_producer = Producers.indexOf(user);
        System.out.println("Notice !! YOUR INCOME WOULD BE 10 PERCENT OF PRICE OF YOUR PRODUCTS WHICH ARE SOLD");
    }
    public void Producer_options(){
        System.out.println("What do you want to do as producer?");
        System.out.println("1-add a product  2-remove a product   3-see your income  4-set sales for your products  5-see your sold products  6-logout ");
        byte choice;
        do {
            choice = input.nextByte();
            switch (choice){
                case 1: addProduct_menu();break;
                case 2: removeProduct();break;
                case 3: System.out.println("Your income is "+Producers_info.get(current_producer).income); Producer_options();break;
                case 4: producer_set_sales();break;
                case 5: show_sold_products();break;
                case 6: show_menu();return;
                default: System.out.println("Your choice should be 1,2,3,4,5 or 6");
            }
        }while (!(choice > 0 && choice < 6));
    }
    public void addProduct_menu(){
        System.out.println("What product you want to add?");
        System.out.println("1-food stuff  2-clothes  3-electronics");
        byte choice;
        do {
            choice = input.nextByte();
            switch (choice){
                case 1:Foodstuff();break;
                case 2:Clothes();break;
                case 3:Electronics();break;
                default:System.out.println("Your choice should be 1,2 or 3");
            }
        }while (!(choice > 0 && choice < 4));
    }
    public void Foodstuff(){
        System.out.println("What kind of food stuff you want to add?");
        System.out.println("1-Fruits and Vegetables  2-Junk Foods  3-Diary");
        byte choice;
        do {
            choice = input.nextByte();
            switch (choice){
                case 1: FruitAndVegetables fruitVeg = new FruitAndVegetables();fruitVeg.producer = current_producer;Products.add(fruitVeg);Producers_info.get(current_producer).current_producer_products.add(fruitVeg);break;
                case 2: JunkFoods junk = new JunkFoods();junk.producer = current_producer;Products.add(junk);Producers_info.get(current_producer).current_producer_products.add(junk);break;
                case 3: Diary diary = new Diary();diary.producer = current_producer;Products.add(diary);Producers_info.get(current_producer).current_producer_products.add(diary);break;
                default: System.out.println("Your choice should be 1,2 or 3");
            }
        }while (!(choice > 0 && choice < 4));
        Producer_options();
    }
    public void Clothes(){
        System.out.println("What kind of clothes you want to add?");
        System.out.println("1-Shoes  2-Shirts  3-Trousers");
        byte choice;
        do {
            choice = input.nextByte();
            switch (choice){
                case 1: Shoes shoe = new Shoes();shoe.producer = current_producer;Products.add(shoe);Producers_info.get(current_producer).current_producer_products.add(shoe);break;
                case 2: Shirt shirt = new Shirt();shirt.producer = current_producer;Products.add(shirt);Producers_info.get(current_producer).current_producer_products.add(shirt);break;
                case 3: Trousers trousers = new Trousers();trousers.producer = current_producer;Products.add(trousers);Producers_info.get(current_producer).current_producer_products.add(trousers);break;
                default: System.out.println("Your choice should be 1,2 or 3");
            }
        }while (!(choice > 0 && choice < 4));
        Producer_options();
    }
    public void Electronics(){
        System.out.println("What kind of electronics you want to add?");
        System.out.println("1-TV  2-Phone  3-Game Console");
        byte choice;
        do {
            choice = input.nextByte();
            switch (choice){
                case 1: TV tv = new TV();Products.add(tv);tv.producer = current_producer;Producers_info.get(current_producer).current_producer_products.add(tv);break;
                case 2: Phone phone = new Phone();phone.producer = current_producer;Products.add(phone);Producers_info.get(current_producer).current_producer_products.add(phone);break;
                case 3: GameConsole gameconsole = new GameConsole();gameconsole.producer = current_producer;Products.add(gameconsole);Producers_info.get(current_producer).current_producer_products.add(gameconsole);break;
                default: System.out.println("Your choice should be 1,2 or 3");
            }
        }while (!(choice > 0 && choice < 4));
        Producer_options();

    }
    public void removeProduct() {
        if (!Producers_info.get(current_producer).current_producer_products.isEmpty()) {
            System.out.println("enter number of the product which you want to remove");
            for (int i = 0; i < Producers_info.get(current_producer).current_producer_products.size(); i++) {
                System.out.print(i + "-" + Producers_info.get(current_producer).current_producer_products.get(i).name + " ");
            }
            System.out.println();
            int wonnaRemove = input.nextInt();
            for (int i = 0; i < Products.size(); i++) {
                if (Products.get(i).name == Producers_info.get(current_producer).current_producer_products.get(wonnaRemove).name) {
                    Products.remove(i);
                }
            }
            Producers_info.get(current_producer).current_producer_products.remove(wonnaRemove);
            Producer_options();
            return;
        }else {
            System.out.println("You don't have any product to remove");
            Producer_options();
            return;
        }
    }
    public void producer_set_sales(){
        System.out.print("How many percent sales do you want to apply to your products? ");
        sale_percent = input.nextDouble();
        if(sale_percent > 0 && sale_percent < 101 && !Products.isEmpty() && !Producers_info.get(current_producer).current_producer_products.isEmpty()) {
            for (int i = 0; i < Producers_info.get(current_producer).current_producer_products.size(); i++) {
                Producers_info.get(current_producer).current_producer_products.get(i).price -= (Producers_info.get(current_producer).current_producer_products.get(i).price * sale_percent / 100);
            }
        }else {
            System.out.println("2 possible errors:");
            System.out.println("1- The entry sale percent should be a number beetween 0 and 100");
            System.out.println("2- no products added from you");
        }
            Producer_options();
    }
    public void show_sold_products(){
        System.out.println("You have sold products below");
        if(!Producers_info.get(current_producer).sold_products_by_current_producer.isEmpty()){
            for (int i = 0; i < Producers_info.get(current_producer).sold_products_by_current_producer.size(); i++) {
                System.out.print(Producers_info.get(current_producer).sold_products_by_current_producer.get(i).name + " price: " + Producers_info.get(current_producer).sold_products_by_current_producer.get(i).price + "  ");
            }
        }else {
            System.out.println("You haven't sold any products or you don't have any product");
        }
        Producer_options();
    }
    ///////////////
    /*Transporter things*/
    public void transporter_sign_in(){
        System.out.print("Please enter your username: ");
        String user;
        String pass;
        do {
            user = input.next();
            if (!Transporters.contains(user)){
                System.out.println("We don't have a transporter with this username");
            }
        }while (!Transporters.contains(user));
        System.out.print("Please enter your password: ");
        do {
            pass = input.next();
            if(!pass.equalsIgnoreCase(Transporters_password.get(Transporters.indexOf(user)))){
                System.out.println("WRONG PASSWORD!! TRY AGAIN!");
            }
        }while (!Transporters_info.get(Transporters.indexOf(user)).password.equals(pass));
        current_transporter = Transporters.indexOf(user);
        System.out.println("Your current vehicle is "+Transporters_info.get(current_transporter).current_veichle.name );
    }
    public void transporter_options(){
        System.out.println("What do you want to do as transporter?");
        System.out.println("1-see customers purchases   2-see my sent-listed products   3-see my sent products   4-change my vehicle  5-see my transported volume   6-logout");
        byte choice;
        do {
            choice = input.nextByte();
            switch (choice){
                case 1: show_compatible_purchases();break;
                case 2: show_in_sent();break;
                case 3: show_sent();break;
                case 4: change_vehicle();break;
                case 5: System.out.println("You have transported total volume of "+Transporters_info.get(current_transporter).transsported_volume);transporter_options();break;
                case 6: show_menu();return;
                default:System.out.println("Your choice should be 1,2,3,4,5 or 6");
            }
        }while (choice<1 || choice>6);
        return;
    }
    public void show_compatible_purchases(){
        if (!Should_be_sent.isEmpty()){
            boolean shown = false;
            for (int i = 0; i < Should_be_sent.size(); i++) {
                if(Should_be_sent.get(i).volume <= Transporters_info.get(current_transporter).current_veichle.volume_max){
                    System.out.println("("+i+"-"+Should_be_sent.get(i).name+"  vol: "+Should_be_sent.get(i).volume+"  "+"category: "+Should_be_sent.get(i).Category+") ");
                    shown = true;
                }
            }
            if (!shown){
                System.out.println("no product in your vehicle volume range");
            }else {
                System.out.println();
                System.out.println("choose a product you want to move into your in send progress list or enter -1 to return home");
                int choose = input.nextInt();
                if (choose == -1){
                    transporter_options();
                }else {
                    Transporters_info.get(current_transporter).Current_transporter_in_progress.add(Should_be_sent.get(choose));
                    in_progress.add(Should_be_sent.get(choose));
                    Should_be_sent.remove(choose);

                }
            }
        }else {
            System.out.println("there is no sold product or they're in another list of yours");
        }
                transporter_options();
        return;
    }
    public void show_in_sent(){
        if (!Transporters_info.get(current_transporter).Current_transporter_in_progress.isEmpty()){
            for (int i = 0; i < Transporters_info.get(current_transporter).Current_transporter_in_progress.size(); i++) {
                    System.out.println("("+i+"-"+Transporters_info.get(current_transporter).Current_transporter_in_progress.get(i).name+"  vol: "+Transporters_info.get(current_transporter).Current_transporter_in_progress.get(i).volume+"  "+"category: "+Transporters_info.get(current_transporter).Current_transporter_in_progress.get(i).Category+") ");

            }
            System.out.println();
            System.out.println("choose a product you want to move into your sent list or enter -1 to return home");
            int choose = input.nextInt();
            if (choose == -1){
                transporter_options();
            }else {
                sent.add(Transporters_info.get(current_transporter).Current_transporter_in_progress.get(choose));
                Transporters_info.get(current_transporter).Current_transporter_sent.add(Transporters_info.get(current_transporter).Current_transporter_in_progress.get(choose));
                Transporters_info.get(current_transporter).transsported_volume += Transporters_info.get(current_transporter).Current_transporter_in_progress.get(choose).volume;
                in_progress.remove(in_progress.indexOf(Transporters_info.get(current_transporter).Current_transporter_in_progress.get(choose)));
                Transporters_info.get(current_transporter).Current_transporter_in_progress.remove(choose);
            }
        }else {
            System.out.println("You don't have any items in sent progress");
        }
        transporter_options();
        return;
    }
    public void show_sent(){
        if (!Transporters_info.get(current_transporter).Current_transporter_sent.isEmpty()){
            for (int i = 0; i < Transporters_info.get(current_transporter).Current_transporter_sent.size(); i++) {
                System.out.println(Transporters_info.get(current_transporter).Current_transporter_sent.get(i).name+"  ");
            }
            System.out.println();
        }else {
            System.out.println("List is empty");
        }
        transporter_options();
        return;
    }
    public void change_vehicle(){
        System.out.println("Your current vehicle is "+Transporters_info.get(current_transporter).current_veichle.name );
        System.out.println("what do you want as the new vehicle of yours?");
        System.out.println("1-Motorcylce   2-Car   3-Truck");
        byte choice;
        do {
            choice = input.nextByte();
            switch (choice){
                case 1: Transporters_info.get(current_transporter).current_veichle = new MotorCycle();break;
                case 2:Transporters_info.get(current_transporter).current_veichle = new Car();break;
                case 3:Transporters_info.get(current_transporter).current_veichle = new Truck();break;
                default:System.out.println("Your choice should be 1,2 or 3");
            }
        }while (choice<1 || choice>3);
        System.out.println("Your current vehicle is "+Transporters_info.get(current_transporter).current_veichle.name );
        transporter_options();
        return;
    }
    ///////////////
    /*customer things*/
    public void two_choice(){
        System.out.println("1-I'm new customer  2-I've already created an account  3-logout");
        byte choice;
        do {
            choice = input.nextByte();
            switch (choice){
                case 1: customer_sign_up();break;
                case 2: customer_sign_in();break;
                case 3: show_menu();break;
                default:System.out.println("Your choice should be 1,2 or 3");
            }
        }while (choice < 1 || choice > 3);
    }
    public void customer_sign_up(){
        Customer c = new Customer();
        System.out.print("set your username: ");
        do {
            c.username = input.next();
            if(Customers.contains(c.username)){
                System.out.println("this username is already taken,Please set another one ");
            }
        } while (Customers.contains(c.username));
        Customers.add(c.username);
        System.out.print("set your password: ");
        c.password = input.next();
        Customers_info.add(c);
        two_choice();
    }
    public void customer_sign_in(){
        System.out.print("Please enter your username: ");
        String user;
        String pass;
        do {
            user = input.next();
            if (!Customers.contains(user)){
                System.out.println("We don't have a customer with this username");
            }
        }while (!Customers.contains(user));
        System.out.print("Please enter your password: ");
        do {
            pass = input.next();
            if(!pass.equalsIgnoreCase(Customers_info.get(Customers.indexOf(user)).password)){
                System.out.println("WRONG PASSWORD!! TRY AGAIN!");
            }
        }while (!pass.equalsIgnoreCase(Customers_info.get(Customers.indexOf(user)).password));
        current_customer = Customers.indexOf(user);
    }
    public void customer_options(){
        System.out.println("What do you want to do as customer?");
        System.out.println("1-buy  2-purchased products  3-spent money  4-in sending progress products  5-logout");
        byte choice;
        do {
            choice = input.nextByte();
            switch (choice){
                case 1:buy_menu();break;
                case 2:show_purchased();break;
                case 3:System.out.println("Your spent money is "+Customers_info.get(current_customer).spent); customer_options();break;
                case 4:show_in_sent_progress();break;
                case 5: show_menu(); return;
                default: System.out.println("Your choice should be 1,2,3,4 or 5");
            }
        }while (choice < 1 || choice > 5);
    }
    public void buy_menu(){
        System.out.println("How would you like to see products");
        System.out.println("1-filtered by producers  2-filtered by categories  3-all products");
        System.out.println("                         4-back to home");
        byte choice;
        do {
            choice = input.nextByte();
            switch (choice){
                case 1:filter_producers();break;
                case 2:filter_categories();break;
                case 3:all_products();break;
                case 4: customer_options();return;
                default: System.out.println("Your choice should be 1,2,3 or 4");
            }
        }while (choice < 1 || choice > 4);

    }
    public void filter_producers(){
        if(!Producers.isEmpty()) {
            System.out.println("Which producer's products you want to see? (enter his number)");
            for (int i = 0; i < Producers.size(); i++) {
                System.out.print(i+"-"+Producers.get(i) + "  ");
            }
            int choice;
            System.out.println();do {
                choice = input.nextInt();
                if (choice >= 0 && choice < Producers.size() && !Producers_info.get(choice).current_producer_products.isEmpty()){
                    System.out.println("enter number of the product to see it's features");
                    int chosen_product;
                    for (int i = 0; i < Producers_info.get(choice).current_producer_products.size(); i++) {
                        System.out.print(i+"-"+Producers_info.get(choice).current_producer_products.get(i).name+"   ");
                    }
                    do {
                    chosen_product = input.nextInt();
                        if(chosen_product < 0 || chosen_product > (Producers_info.get(choice).current_producer_products.size() - 1)){
                            System.out.println("TRY AGAIN!");
                        }else {
                            show_features(Producers_info.get(choice).current_producer_products.get(chosen_product));
                            System.out.println("1-buy this  2-choose another  3-back to buy menu");
                            byte choice_1;
                            do {
                                choice_1 = input.nextByte();
                                switch (choice_1){
                                    case 1: buy(Producers_info.get(choice).current_producer_products.get(chosen_product)); break;
                                    case 2: chosen_product = Producers_info.get(choice).current_producer_products.size();break;
                                    case 3: buy_menu();return;
                                    default: System.out.println("Your choice should be 1,2 or 3");
                                }
                            }while (choice_1 < 0 || choice_1 > 3);
                        }
                    }while (chosen_product < 0 || chosen_product > (Producers_info.get(choice).current_producer_products.size() - 1) );
                }else {
                    System.out.println("Try again in chosing producer possible 2 errors:");
                    System.out.println("1-chosen producer doesn't have any product   2-chosen number is not valid");
                    System.out.println("return to  buy menu by entering 0");
                    byte choose = input.nextByte();
                    if(choose == 0){
                        buy_menu();
                        return;
                    }else{

                    }
                }
            }while (choice < 0 || choice > (Producers.size() - 1));

        }else {
            System.out.println("We don't have any producers");
        }
        buy_menu();
        return;
    }
    public void filter_categories(){
        if (!Products.isEmpty()) {
            System.out.println("We have 3 main categories::: 1-Foods Stuff   2-Clothes   3-Electronics");
            byte main_categ;
            boolean food = false;
            boolean clothes = false;
            boolean electronics = false;
            do {
                main_categ = input.nextByte();
                switch (main_categ) {
                    case 1:
                        System.out.println("1-Fruits and vegetables  2-Junk foods  3-diary  4-all food stuff");
                        food = true;
                        break;
                    case 2:
                        System.out.println("1-shoes  2-shirts  3-trousers  4-all clothes");
                        clothes = true;
                        break;
                    case 3:
                        System.out.println("1-Televisions  2-phones  3-game consoles  4-all electronics");
                        electronics = true;
                        break;
                    default:
                        System.out.println("your choice should be 1,2 or 3");
                }
            } while (main_categ < 1 || main_categ > 3);
            byte in_categ_chose;
            if (food) {

                do {
                    in_categ_chose = input.nextByte();
                    switch (in_categ_chose) {
                        case 1:
                            for (int i = 0; i < Products.size(); i++)
                                if (Products.get(i) instanceof FruitAndVegetables)
                                    System.out.print(i + "-" + Products.get(i).name + "  ");
                            break;
                        case 2:
                            for (int i = 0; i < Products.size(); i++)
                                if (Products.get(i) instanceof JunkFoods)
                                    System.out.print(i + "-" + Products.get(i).name + "  ");
                            ;
                            break;
                        case 3:
                            for (int i = 0; i < Products.size(); i++)
                                if (Products.get(i) instanceof Diary)
                                    System.out.print(i + "-" + Products.get(i).name + "  ");
                            break;
                        case 4:
                            for (int i = 0; i < Products.size(); i++)
                                if (Products.get(i) instanceof FoodStuff)
                                    System.out.print(i + "-" + Products.get(i).name + "  ");
                            break;
                        default:
                            System.out.println("your choice should be 1,2,3 or 4");
                    }
                } while (in_categ_chose < 1 || in_categ_chose > 4);
            } else if (clothes) {
                do {
                    in_categ_chose = input.nextByte();
                    switch (in_categ_chose) {
                        case 1:
                            for (int i = 0; i < Products.size(); i++)
                                if (Products.get(i) instanceof Shoes)
                                    System.out.print(i + "-" + Products.get(i).name + "  ");
                            break;
                        case 2:
                            for (int i = 0; i < Products.size(); i++)
                                if (Products.get(i) instanceof Shirt)
                                    System.out.print(i + "-" + Products.get(i).name + "  ");
                            break;
                        case 3:
                            for (int i = 0; i < Products.size(); i++)
                                if (Products.get(i) instanceof Trousers)
                                    System.out.print(i + "-" + Products.get(i).name + "  ");
                            break;
                        case 4:
                            for (int i = 0; i < Products.size(); i++)
                                if (Products.get(i) instanceof Clothes)
                                    System.out.print(i + "-" + Products.get(i).name + "  ");
                            break;
                        default:
                            System.out.println("your choice should be 1,2,3 or 4");
                    }
                } while (in_categ_chose < 1 || in_categ_chose > 4);

            } else if (electronics) {
                do {
                    in_categ_chose = input.nextByte();
                    switch (in_categ_chose) {
                        case 1:
                            for (int i = 0; i < Products.size(); i++)
                                if (Products.get(i) instanceof TV)
                                    System.out.print(i + "-" + Products.get(i).name + "  ");
                            break;
                        case 2:
                            for (int i = 0; i < Products.size(); i++)
                                if (Products.get(i) instanceof Phone)
                                    System.out.print(i + "-" + Products.get(i).name + "  ");
                            break;
                        case 3:
                            for (int i = 0; i < Products.size(); i++)
                                if (Products.get(i) instanceof GameConsole)
                                    System.out.print(i + "-" + Products.get(i).name + "  ");
                            break;
                        case 4:
                            for (int i = 0; i < Products.size(); i++)
                                if (Products.get(i) instanceof Electronics)
                                    System.out.print(i + "-" + Products.get(i).name + "  ");
                            break;
                        default:
                            System.out.println("your choice should be 1,2,3 or 4");
                    }
                } while (in_categ_chose < 1 || in_categ_chose > 4);
            }
            System.out.println();
            System.out.println("enter number of the product you want to see it's features or enter -1 to back to buy menu");
            int choosen = input.nextInt();
            if (choosen == -1) {
                buy_menu();return;
            } else {
                show_features(Products.get(choosen));
                System.out.println("1-buy this   2-back to buy menu");
                int choice;
                do {
                    choice = input.nextByte();
                    if (choice == 1) {
                        buy(Products.get(choosen));
                    } else if (choice == 2) {
                        buy_menu();
                        return;
                    } else {
                        System.out.println("your choice should be 1 or 2");
                    }

                } while (choice < 1 || choice > 2);
            }
        }else {
                System.out.println("We don't have any product yet");
                customer_options();

        }
        }
    public void all_products(){
        if(!Products.isEmpty()){
            System.out.println("You are looking at list of our all products enter number of one you want to see it's info");
            for (int i = 0; i < Products.size() ; i++) {
                System.out.println(i+"-"+Products.get(i).name+"  ");
            }
            System.out.println();
            int chosen_product;
            do {
                chosen_product = input.nextInt();
                if (chosen_product < 0 || chosen_product > Products.size() - 1){
                    System.out.println("please enter a valid number");
                }else{
                    show_features(Products.get(chosen_product));
                    System.out.println("1-buy this  2-back to buy menu");
                    byte choice;
                    do {
                        choice = input.nextByte();
                        switch (choice){
                            case 1: buy(Products.get(chosen_product));break;
                            case 2: buy_menu();return;
                            default: System.out.println("Your choice should be 1 or 2");
                        }
                    }while (choice< 1 || choice > 2);
                }
            }while (chosen_product < 0 || chosen_product > (Products.size() - 1));


        }else {
            System.out.println("We don't have any product");
            customer_options();
            return;
        }
    }
    public void show_features(Product prod){
        System.out.print("Price: "+prod.price + " " + "Volume: "+prod.volume+" "+"Category: "+prod.Category+" ");
        if(prod instanceof FruitAndVegetables){
            System.out.print("Expire days: "+((FruitAndVegetables) prod).ExpireDays+" Production city: "+((FruitAndVegetables) prod).ProductionCity);
        }else if (prod instanceof JunkFoods){
            System.out.print("Expire days: "+((JunkFoods) prod).ExpireDays);
        }else if (prod instanceof Diary){
            System.out.print("Expire days: "+((Diary) prod).ExpireDays);
        }else if (prod instanceof Shoes){
            System.out.print("For: "+((Shoes) prod).Gender+" Size: "+((Shoes) prod).Size+" Material: "+((Shoes) prod).Material);
        }else if (prod instanceof Shirt){
            System.out.print(" For: "+((Shirt) prod).Gender+" Size: "+((Shirt) prod).size+" Material: "+((Shirt) prod).Material);
        }else if(prod instanceof Trousers){
            System.out.print(" For: "+((Trousers) prod).Gender+" Size: "+((Trousers) prod).size+" MAterial: "+((Trousers) prod).Material);
        }else if (prod instanceof TV){
            System.out.print(" Release date: "+((TV) prod).production_year+" Display: "+((TV) prod).display_size);
        }else if(prod instanceof Phone){
            System.out.print(" Release date: "+ ((Phone) prod).production_year+" Display: "+((Phone) prod).display_size);
        }else if (prod instanceof GameConsole){
            System.out.print(" Release date: "+((GameConsole) prod).production_year);
            System.out.println();
            System.out.print("Accessories: ");
            for (int i = 0; i < ((GameConsole) prod).Accessories.size(); i++) {
                System.out.print(((GameConsole) prod).Accessories.get(i)+"  ");
            }
        }
        System.out.println();
    }
    public void buy(Product prod){
        prod.for_customer = current_customer;
        Customers_info.get(current_customer).spent += prod.price;
        Customers_info.get(current_customer).purchased.add(prod);
        Customers_info.get(current_customer).in_sent_progress.add(prod);
        Producers_info.get(prod.producer).income += prod.price/10;
        Producers_info.get(prod.producer).sold_products_by_current_producer.add(prod);
        all_purchases.add(prod);
        Should_be_sent.add(prod);
        customer_options();
        return;
    }
    public void show_in_sent_progress(){
        if (!Customers_info.get(current_customer).in_sent_progress.isEmpty() && (!in_progress.isEmpty() || !sent.isEmpty())){
            for (int i = 0; i < Customers_info.get(current_customer).in_sent_progress.size(); i++) {
                if (in_progress.contains(Customers_info.get(current_customer).in_sent_progress.get(i)) || sent.contains(Customers_info.get(current_customer).in_sent_progress.get(i))) {
                    System.out.print(Customers_info.get(current_customer).in_sent_progress.get(i).name + " volume: " + Customers_info.get(current_customer).in_sent_progress.get(i).volume + "  ");
                }
            }
            System.out.println();
        }else {
            System.out.println("You don't have any in sent progress product");
        }
        customer_options();
        return;
    }
    public void show_purchased() {
        if (!Customers_info.get(current_customer).purchased.isEmpty()) {
            System.out.println("Your purchased items");
            for (int i = 0; i < Customers_info.get(current_customer).purchased.size(); i++) {
                System.out.print(i+"-"+Customers_info.get(current_customer).purchased.get(i).name + " ");
            }
            System.out.println();
            System.out.println("1-I want info of a purchased item  2-back to home");
            byte choice;
            do {
                choice = input.nextByte();
                switch (choice) {
                    case 1:
                        System.out.println("Please enter the number of product you want to see it's info");
                        int chosen_product = input.nextInt();show_features(Customers_info.get(current_customer).purchased.get(chosen_product));
                        break;
                    case 2:
                        customer_options();
                        return;
                    default:
                        System.out.println("Your choice should be 1 or 2");
                }
            } while (choice < 1 || choice > 2);
        }else {
            System.out.println("You havent purchased anything!");
        }
        customer_options();
        return;
    }
    ///////////////
    /*statistics things*/
    public void show_income(){
        if (!Producers.isEmpty()){
        System.out.println("which producer you want to see?");
            for (int i = 0; i <= Producers.size() ; i++) {
                if (i < Producers.size()) {
                    System.out.print(i+"-"+Producers.get(i)+" ");
                }else {
                    System.out.print(i+"-"+"totatl incomes");
                }
            }
            System.out.println();
            int choice = input.nextInt();
            if (choice != Producers.size()){
                System.out.println(Producers_info.get(choice).username+" income is "+ Producers_info.get(choice).income);
            }else {
                double total = 0;
                for (int i = 0; i < Producers_info.size() ; i++) {
                    total += Producers_info.get(i).income;
                }
                System.out.println("total incomes is "+ total);
            }
        }else {
            System.out.println("No producers");
        }
    }
    public void show_spent(){
        if(!Customers.isEmpty()){
            System.out.println("Which customer you want to see?");
            for (int i = 0; i <= Customers.size(); i++) {
                if (i < Customers.size()){
                    System.out.print(i+"-"+Customers.get(i)+" ");
                }else {
                    System.out.print(i+"-"+"total spent money");
                }
            }
            System.out.println();
            int choice = input.nextInt();
            if (choice != Customers.size()){
                System.out.println(Customers_info.get(choice).username+" spent money is "+ Customers_info.get(choice).spent);
            }else {
                double total = 0;
                for (int i = 0; i < Customers_info.size() ; i++) {
                    total += Customers_info.get(i).spent;
                }
                System.out.println("total spent money is "+ total);
            }
        }else {
            System.out.println("No customers");
        }
    }
    public void show_volume(){
        if (!Transporters.isEmpty()){
            System.out.println("Which transporter you want to see?");
            for (int i = 0; i <= Transporters.size(); i++) {
                if (i < Transporters.size()){
                    System.out.print(i+"-"+Transporters.get(i)+" ");
                }else {
                    System.out.print(i+"-"+"total transported volume");
                }
            }
            System.out.println();
            int choice = input.nextInt();
            if (choice != Transporters.size()){
                System.out.println(Transporters_info.get(choice).username+" transported volume is "+ Transporters_info.get(choice).transsported_volume);
            }else {
                double total = 0;
                for (int i = 0; i < Transporters_info.size() ; i++) {
                    total += Transporters_info.get(i).transsported_volume;
                }
                System.out.println("total transported volume is "+ total);
            }

        }else {
            System.out.println("No transporters");
        }
    }
    public void show_sold_for_admin(){
        if(!all_purchases.isEmpty()){
            System.out.println("which producer you want to see?");
            for (int i = 0; i <= Producers.size() ; i++) {
                if (i < Producers.size()) {
                    System.out.print(i+"-"+Producers.get(i)+" ");
                }else {
                    System.out.print(i+"-"+"totatl sold products");
                }
            }
            System.out.println();
            int choice = input.nextInt();
            if (choice != Producers.size()){
                if(!Producers_info.get(choice).sold_products_by_current_producer.isEmpty()){
                    for (int i = 0; i < Producers_info.get(choice).sold_products_by_current_producer.size(); i++) {
                        System.out.print(i+"-"+Producers_info.get(choice).sold_products_by_current_producer.get(i).name+" ");
                    }
                }else {
                    System.out.println("No sold items by this producer");
                }
            }else {
                for (int i = 0; i < all_purchases.size() ; i++) {
                    System.out.print(i+"-"+all_purchases.get(i).name+" ");
                }
            }
            System.out.println();
        }else {
            System.out.println("No sold product");
        }
    }
    public void show_purchased_for_admin(){
        if(!all_purchases.isEmpty()){
            System.out.println("which customer you want to see?");
            for (int i = 0; i <= Customers.size() ; i++) {
                if (i < Customers.size()) {
                    System.out.print(i+"-"+Customers.get(i)+" ");
                }else {
                    System.out.print(i+"-"+"totatl purchased products");
                }
            }
            System.out.println();
            int choice = input.nextInt();
            if (choice != Customers.size()){
                if(!Customers_info.get(choice).purchased.isEmpty()){
                    for (int i = 0; i < Customers_info.get(choice).purchased.size(); i++) {
                        System.out.print(i+"-"+Customers_info.get(choice).purchased.get(i).name+" ");
                    }
                }else {
                    System.out.println("No purchased items by this customer");
                }
            }else {
                for (int i = 0; i < all_purchases.size() ; i++) {
                    System.out.print(i+"-"+all_purchases.get(i).name+" ");
                }
            }
            System.out.println();
        }else {
            System.out.println("No purchases from customers");
        }

    }
    public void show_transported_for_admin(){
        if(!sent.isEmpty()){
            System.out.println("which transporter you want to see?");
            for (int i = 0; i <= Transporters.size() ; i++) {
                if (i < Transporters.size()) {
                    System.out.print(i+"-"+Transporters.get(i)+" ");
                }else {
                    System.out.print(i+"-"+"totatl sent(transported) products");
                }
            }
            System.out.println();
            int choice = input.nextInt();
            if (choice != Transporters.size()){
                if(!Transporters_info.get(choice).Current_transporter_sent.isEmpty()){
                    for (int i = 0; i < Transporters_info.get(choice).Current_transporter_sent.size(); i++) {
                        System.out.print(i+"-"+Transporters_info.get(choice).Current_transporter_sent.get(i).name+" ");
                    }
                }else {
                    System.out.println("No sent(transported) items by this transporter");
                }
            }else {
                for (int i = 0; i < sent.size() ; i++) {
                    System.out.print(i+"-"+sent.get(i).name+" ");
                }
            }
            System.out.println();
        }else {
            System.out.println("No sent(transported) product");
        }
    }
    ///////////////
    /*main menu off application*/
    public void show_menu(){
        System.out.println("Please Choose Your Account Type");
        System.out.println("1.Admin  2.Producer  3.Transporter  4.Customer");
        System.out.println("                 5.exit");
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
                case 5: return;
                default:
                    System.out.print("Try again! ");
                    break;
            }
        } while (choice_1 < 1 || choice_1 > 5);
        ////////////
        /*each account menus*/
        if (admin_menu){
            System.out.println("You want to enter as admin");
            Admin_sign_in();
            admin_options();
        }else if(producer_menu){
            System.out.println("You want to enter as producer");
            Producer_sign_in();
            Producer_options();
        }else if (transporter_menu){
            System.out.println("You want to enter as transporter");
            transporter_sign_in();
            transporter_options();

        } else if(customer_menu){
            System.out.println("You want to enter as customer");
            two_choice();
            customer_options();
        }
        /////////////

    }
}


