package com.company;

import java.util.LinkedList;
import java.util.Scanner;

public class Product extends Producer {
    Scanner input = new Scanner(System.in);
    public String name;
    public double price;
    public double volume;
    public String factory;
    public int producer = -1;//will be set when created
    public int for_customer = -1;//will be set when someone buy this
    public String Category;

    public Product() {
        System.out.print("Production name: ");
        this.name = input.next();
        System.out.print("Factory name: ");
        this.factory = input.next();
        System.out.print("Production's price: ");
        this.price = input.nextDouble();
        System.out.print("Production's volume: ");
        this.volume = input.nextDouble();
    }
}
/*food stuff*/

class FoodStuff extends Product {
    public int ExpireDays;

    public FoodStuff() {
        System.out.print("Production's expire days: ");
        this.ExpireDays = input.nextInt();
    }
}

class FruitAndVegetables extends FoodStuff {
    public String ProductionCity;

    public FruitAndVegetables() {
        System.out.print("Production city name: ");
        this.ProductionCity = input.next();
        Category = "FruitsAndVegetables";
    }
}

class JunkFoods extends FoodStuff {
    public JunkFoods(){
        Category = "Junkfoods";
    }
}

class Diary extends FoodStuff {
    public Diary(){
        Category = "Diary";
    }
}
////////////////////////////////////////////////
/*clothes*/
class Clothes extends Product {
    public String Gender;
    boolean genChoose = false;

    public Clothes() {
        System.out.print("this product is for 1.Men 2.Women 3.Boys 4.Girls?");
        while (!genChoose) {
            byte choose = input.nextByte();
            switch (choose) {
                case 1:
                    this.Gender = "Men";
                    genChoose = true;
                    break;
                case 2:
                    this.Gender = "Women";
                    genChoose = true;
                    break;
                case 3:
                    this.Gender = "Boys";
                    genChoose = true;
                    break;
                case 4:
                    this.Gender = "Girls";
                    genChoose = true;
                    break;
                default:
                    break;
            }
        }
    }
}
class Shoes extends Clothes{
   public double Size;
   public String Material;
   public Shoes(){
       System.out.print("Shoe's size: ");
       this.Size = input.nextDouble();
       System.out.print("Shoe's material: ");
       this.Material = input.next();
       Category = "Shoes";
   }
}
class Shirt extends Clothes{
    public String size;
    public String Material;
    public Shirt(){
        System.out.print("Shirt's size: ");
        this.size = input.next();
        System.out.print("Shirt's material: ");
        this.Material = input.next();
        Category = "Shirts";
    }
}
class Trousers extends Clothes{
    public String size;
    public String Material;
    public Trousers(){
        System.out.print("Trousers's size: ");
        this.size = input.next();
        System.out.print("Trousers's material: ");
        this.Material = input.next();
        Category = "Trousers";
    }
}
//////////////////////////////
/*Electronics*/
class Electronics extends Product{
    public int production_year;
    public Electronics(){
        System.out.print("production year: ");
        this.production_year = input.nextInt();
    }
}
class TV extends Electronics{
    double display_size;
    public TV(){
        System.out.print("TV's display size: ");
        this.display_size = input.nextDouble();
        Category = "Televisions";
    }
}
class Phone extends Electronics{
    double display_size;
    public Phone(){
        System.out.print("Phone's display size: ");
        this.display_size = input.nextDouble();
        Category = "Phones";
    }
}
class GameConsole extends Electronics{
    LinkedList<String> Accessories = new LinkedList<String>();
    public GameConsole(){
        int accessories_size;
        System.out.print("How many accessories this product has? ");
        accessories_size = input.nextInt();
        System.out.print("enter game console's accessories: ");
        for (int i = 0; i < accessories_size; i++) {
            String Accessory = null;
            Accessory = input.next();
            Accessories.add(Accessory);
        }
        Category = "GameConsoles";
    }
}