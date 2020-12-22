package edu.umb.cs681.hw20;

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

        System.out.println("Get the minimum price");
        Integer minPrice = cars.stream()
                .parallel()
                .map((Car car) -> car.getPrice())
                .reduce(0, (result, carPrice)->{
                            if(result==0) return carPrice;
                            else if(carPrice < result) return carPrice; else return result;},
                        (finalResult, interMediateResult)->{
                            System.out.println(Thread.currentThread().getName() + " : finalResult = " + finalResult + "; interMediateResult = " + interMediateResult);
                            return (finalResult < interMediateResult)? finalResult:interMediateResult;
                        });
        System.out.println("The Min price is" + minPrice);

        System.out.println("Get the maximum price");
        Integer maxPrice = cars.stream()
                .map((Car car) -> car.getPrice())
                .parallel()
                .reduce(0, (result, carPrice) -> {
                    if(result == 0) return carPrice;
                    else if(carPrice >= result) return carPrice;
                    else return result;
                }, 					    (finalResult, interMediateResult)->{
                    System.out.println(Thread.currentThread().getName() + " : finalResult = " + finalResult + "; interMediateResult = " + interMediateResult);
                    return (finalResult > interMediateResult)? finalResult:interMediateResult;
                });
        System.out.println("The Max price is" + maxPrice);

        System.out.println("Get the count ");
        Integer count = cars.stream()
                .parallel()
                .map((Car car) -> car.getPrice())
                .reduce(0, (result, car) -> {
                    if(car != null) return ++result;
                    return result;
                },										(finalResult,intermediateResult)->{
                    System.out.println(Thread.currentThread().getName() + " : finalResult = " + finalResult + "; interMediateResult = " + intermediateResult);
                    return finalResult + intermediateResult;
                });
        System.out.println("The count is" + count);

        System.out.println("Count the number of makes");
        Integer numberOfModel = cars.stream()
                .parallel()
                .map((Car car) -> car.getMake())
                .distinct()
                .reduce(0, (result, model) -> {
                    return ++result;
                }, (finalResult,intermediateResult) -> {
                    System.out.println(Thread.currentThread().getName() + " : finalResult = " + finalResult + "; interMediateResult = " + intermediateResult);
                    return finalResult+intermediateResult;
                });

        System.out.println("The Number of Models is" + numberOfModel);


    }
}