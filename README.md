# MHKALA: A Console-Based E-Commerce System

Welcome to MHKALA, a fully-featured e-commerce and logistics simulation built entirely in Java. This project models a dynamic online marketplace where Producers, Customers, and Transporters interact within a single ecosystem, all managed by a central Admin.

This application was developed as a comprehensive exercise in Object-Oriented Programming, demonstrating principles like inheritance, encapsulation, and polymorphism to create a scalable and logical system architecture.

## Table of Contents

- [About The Project](#about-the-project)
- [Key Features](#key-features)
- [Object-Oriented Design](#object-oriented-design)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [How to Run](#how-to-run)
- [How It Works](#how-it-works)
  - [The Four User Roles](#the-four-user-roles)
  - [Product Catalog](#product-catalog)

## About The Project

MHKALA brings the complexity of an online store to the command line. It's a simulation that allows users to perform real-world e-commerce actions based on their assigned role. Producers can list their products, customers can browse and buy, and transporters handle the logistics of delivering the goods. An administrator oversees the entire operation, managing users and viewing system-wide analytics.

The project is designed to be robust, handling all interactions, data storage, and business logic through the console.

## Key Features

- **Multi-Role User System:** Four distinct user roles with unique permissions and functionalities:
  - **Admin:** Manages the system, adds Producers/Transporters, and views all statistics.
  - **Producer:** Adds/removes products from the store and tracks their income. 
  - **Customer:** Signs up, browses products by category or producer, makes purchases, and tracks orders.  
  - **Transporter:** Views available delivery jobs, accepts them based on vehicle capacity, and manages their delivery queue. 
- **Hierarchical Product Catalog:** A diverse range of products organized into nested categories:
  - **Foodstuff:** Fruits, Junk Food, Dairy. 
  - **Apparel:** Shoes, Shirts, Trousers. 
  - **Electronics:** TVs, Phones, Game Consoles. 
- **Dynamic Order Lifecycle:** Full simulation of the ordering process, from a customer's purchase to a transporter's final delivery. 
- **Detailed Statistics Engine:** Each user can view stats relevant to their role (e.g., a customer's total spending, a producer's income). The admin has a global view of all analytics. 

## Object-Oriented Design

This project was built with a strong focus on OOP principles:

-   **Inheritance:** The product system uses a base `Product` class, which is extended by `FoodStuff`, `Clothes`, and `Electronics`. These, in turn, are extended by more specific item classes (e.g., `Shirt`, `Phone`). Similarly, the `Vehicle` class is the parent to `MotorCycle`, `Car`, and `Truck`.
-   **Encapsulation:** Each class (`Customer`, `Producer`, etc.) bundles its own data and methods, exposing only necessary functionalities and hiding the internal implementation details.
-   **Polymorphism:** The application uses collections like `LinkedList<Product>` to manage different types of products seamlessly. This allows the system to handle any object that is a `Product` without needing to know its specific subclass, simplifying code for inventory and purchase management.

## Getting Started

To get a local copy up and running, follow these simple steps.

### Prerequisites

You will need a Java Development Kit (JDK) installed on your machine. Version 8 or newer is recommended.

### How to Run

1.  **Clone the Repository**
    ```sh
    git clone [https://github.com/your-username/your-repository-name.git](https://github.com/your-username/your-repository-name.git)
    cd your-repository-name
    ```

2.  **Compile the Java Files**
    Navigate to the root directory containing the `src` folder and run the following command to compile all the source files:
    ```sh
    javac src/com/company/*.java
    ```

3.  **Run the Application**
    Execute the program by running the `Main` class:
    ```sh
    java -cp src com.company.Main
    ```
    The application will now start in your console!

## How It Works

The entire application operates through a series of interactive console menus.

### The Four User Roles

1.  **Admin Setup (First Run)**: The first time you launch the application, you will be prompted to create the master **Admin** account.  10, 13] This account is your entry point to managing the marketplace.

2.  **Admin Panel**: Once logged in, the Admin can:
    -   Create new **Producer** and **Transporter** accounts.  
    -   Apply store-wide sales discounts to all products.  
    -   View detailed statistics on income, spending, and logistics.  

3.  **Producer Panel**: Producers can log in to:
    -   Add new products under various categories.  
    -   Remove their existing products from the store. 
    -   View their total income and a list of all products they have sold.  

4.  **Customer Experience**: Customers have a complete shopping experience where they can:
    -   Create a new account or log in to an existing one.  
    -   Browse the entire product catalog, with options to filter by producer or category.  
    -   View detailed product information before buying.
    -   Purchase items, which are then placed in a queue for delivery.  
    -   Check the status of their items in transit. 

5.  **Transporter Dashboard**: Transporters are the backbone of the delivery system. They can:
    -   View a public list of all purchased items waiting for shipment. 
    -   Accept delivery jobs for items whose volume fits their current vehicle's capacity (`Motorcycle`, `Car`, or `Truck`).  
    -   Manage their accepted jobs in an "In Progress" list and move them to a "Delivered" list upon completion.  
    -   Change their vehicle at any time to accommodate different load sizes.  

### Product Catalog

The store features a wide array of products, each with unique attributes defined by its category. For example:
-   An **Electronic** item like a `Phone` will have a `display_size` and `production_year`.  
-   An **Apparel** item like a `Shirt` will have a `size` (S/M/L) and `Material`. 
-   A **Foodstuff** item like `FruitAndVegetables` will have an `ExpireDays` property and a `ProductionCity`.  

This detailed class structure allows for a realistic and varied shopping experience.
