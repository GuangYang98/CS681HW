package edu.umb.cs681.hw03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Car{
    private int price;
    private String maker;
    private int year;
    private int mileage;

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

    public static void main(String[] args){
        ArrayList<Car> cars = new ArrayList<Car>(
                Arrays.asList(
                        new Car(5000, "Honda", 2014, 63422),
                        new Car(12000, "Toyota", 2016, 34562),
                        new Car(8000, "Audi", 2010, 103827),
                        new Car(20000, "Tesla", 2018, 50293)
                )
        );

        //minimun price
       Integer minPrice = cars.stream().map((Car car) -> car.getPrice()).reduce(0, (result, carPrice) -> {
           if (result == 0) return carPrice;
           else if (carPrice < result) return  carPrice;
           else return result;
       });
       System.out.println("Minimun price is " + minPrice);

       //maximum price
        Integer maxPrice = cars.stream().map((Car car) -> car.getPrice()).reduce(0, (result, carPrice) -> {
            if (result == 0) return carPrice;
            else if (carPrice > result) return  carPrice;
            else return result;
        });
        System.out.println("Maximun price is " + maxPrice);

        //count the number
        Integer number = cars.stream().map((Car car) -> car.getMake()).reduce(0, (result, carMaker) -> ++result, (finalResult, intermediateResult) -> finalResult);
        System.out.println("There are "+ number + "");
    }
}