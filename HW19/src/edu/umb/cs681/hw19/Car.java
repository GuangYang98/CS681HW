package edu.umb.cs681.hw19;

import java.util.ArrayList;

public class Car{
    private int price;
    private String maker;
    private int year;
    private int mileage;
    private int dominationCount;

    public Car(int price, String make, int year, int mileage) {
        this.price = price;
        this.maker = make;
        this.year = year;
        this.mileage = mileage;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public void setMake(String make){
        this.maker = make;
    }

    public void setYear(int year){
        this.year = year;
    }

    public void setMileage(int mileage){
        this.mileage = mileage;
    }

    public int getPrice(){
        return price;
    }

    public String getMake(){
        return maker;
    }

    public int getYear(){
        return year;
    }

    public int getMileage(){
        return mileage;
    }

    public void setDominationCount(ArrayList<Car> cars){
        for (Car c :cars){
            if(this.getMileage() >= c.getMileage() && this.getPrice() >= c.getPrice() && this.getYear() <=c.getYear()){
                if(this.getMileage()> c.getMileage() || this.getPrice() >c.getPrice() || this.getYear()<c.getYear()){
                    this.dominationCount++;
                }
            }
        }
    }

    public int getDominationCount(){
        return this.dominationCount;
    }

}