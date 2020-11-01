package edu.umb.cs681.hw04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class CurrencyExchange {
    private double rate;
    private String name;

    public CurrencyExchange(double rate, String name){
        this.rate = rate;
        this.name = name;
    }

    public double getRate(){
        return this.rate;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return this.rate+" "+this.name;
    }

    public static void main(String args[]) {

        ArrayList<CurrencyExchange> list = new ArrayList<>(
                Arrays.asList(new CurrencyExchange(0.15, "CNY->USD"),
                              new CurrencyExchange(1.17, "EUR->USD"),
                              new CurrencyExchange(1.29, "GBP->USD"),
                              new CurrencyExchange(0.70, "AUD->USD")
                ));

        long numberOfNames = list.stream().count();
        System.out.println("There are " + numberOfNames + " names.");

        CurrencyExchange maxRate = list.stream().max(Comparator.comparing(CurrencyExchange::getRate)).get();
        System.out.println("The max rate is " + maxRate);

        ArrayList<CurrencyExchange> sortedByPerRate = list.stream().sorted(Comparator.comparing(CurrencyExchange::getRate)).collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Sorted list is");
        sortedByPerRate.forEach((CurrencyExchange cur) -> System.out.println(cur));
    }
}
