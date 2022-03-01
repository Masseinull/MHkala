package com.company;

public class Producer extends Admin {
    String username;
    String password;
    public Producer(String username,String password){
        this.username = username;
        this.password = password;
        Producers.add(username);
    }
    public void Producer_sign_in(){
        System.out.println("Producer Please enter your username");
        String user;
        String pass;
        do {
            user = input.nextLine();
            if (user.equalsIgnoreCase(this.username)){
                break;
            }else {
                System.out.println("Not a Producer , tell admin!");
            }
        }while (!user.equalsIgnoreCase(this.username));
        System.out.println(this.username+" Please enter your password");
        do {
            pass = input.nextLine();
            if (pass.equalsIgnoreCase(this.password)){
                System.out.println(this.username+" Signed-in Successfully");
            }else {
                System.out.println("TRY AGAIN!");
            }
        }while (!pass.equalsIgnoreCase(this.password));
    }
}
