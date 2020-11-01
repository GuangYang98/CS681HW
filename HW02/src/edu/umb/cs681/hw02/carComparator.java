package edu.umb.cs681.hw02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class carComparator{
    static ArrayList<Car> cars = new ArrayList<Car>(
        Arrays.asList(
                new Car(5000, "Honda", 2014, 63422),
                new Car(12000, "Toyota", 2016, 34562),
                new Car(8000, "Audi", 2010, 103827),
                new Car(20000, "Tesla", 2018, 50293)
        )
    );



    public static void main(String[] args){
        System.out.println("Sorted by year:");
        ArrayList<Car> sortedYear = cars.stream().sorted(Comparator.comparing(Car :: getYear, Comparator.reverseOrder())).collect(Collectors.toCollection(ArrayList::new));
        sortedYear.forEach((Car car) -> System.out.println(car.getMake()+ ":" + car.getYear()));

        System.out.println("Sorted by price:");
        ArrayList<Car> sortedPrice = cars.stream().sorted(Comparator.comparing(Car :: getPrice)).collect(Collectors.toCollection(ArrayList::new));
        sortedPrice.forEach((Car car) -> System.out.println(car.getMake()+ ":" + car.getPrice()));

        System.out.println("Sorted by mileage:");
        ArrayList<Car> sortedMileage = cars.stream().sorted(Comparator.comparing(Car :: getMileage)).collect(Collectors.toCollection(ArrayList::new));
        sortedMileage.forEach((Car car) -> System.out.println(car.getMake()+ ":" + car.getMileage()));

        System.out.println("Sorted by dominationCount:");
        cars.forEach((Car car)->car.setDominationCount(cars));
        ArrayList<Car> sortedDominationCount = cars.stream().sorted(Comparator.comparing(Car :: getDominationCount, Comparator.reverseOrder())).collect(Collectors.toCollection(ArrayList::new));
        sortedDominationCount.forEach((Car car) -> System.out.println(car.getMake()+ ":" + car.getDominationCount()));

    }
}