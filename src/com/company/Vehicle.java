package com.company;

public class Vehicle extends Transporter {
    protected double volume_max;
    protected String name;
}
class MotorCycle extends Vehicle{
    public MotorCycle(){
        this.volume_max = 0.5;
        this.name = "MotorCycle";
    }
}
class Car extends Vehicle{
    public Car(){
        this.volume_max = 2;
        this.name = "Car";
    }
}
class Truck extends Vehicle{
    public Truck(){
        this.volume_max = 12;
        this.name = "Truck";
    }
}