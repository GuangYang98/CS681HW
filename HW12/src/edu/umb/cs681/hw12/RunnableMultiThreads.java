package edu.umb.cs681.hw12;

public class RunnableMultiThreads implements Runnable{

    public static void main(String[] args){

        RunnableMultiThreads threads1 = new RunnableMultiThreads();
        RunnableMultiThreads threads2 = new RunnableMultiThreads();
        RunnableMultiThreads threads3 = new RunnableMultiThreads();

        new Thread(threads1).start();
        new Thread(threads2).start();
        new Thread(threads3).start();
    }

    public void run(){
        Address addr1 = new Address("70 pacific st", "Cambridge", "MA", 2139);
        Customer customer = new Customer(addr1);
        System.out.println(customer.getAddress().toString());

        customer.setAddress(new Address("150 western st", "Malden", "MA", 2125));
        System.out.println(customer.getAddress().toString());

        customer.setAddress(customer.getAddress().change("89 brookline st", "Boston", "MA", 2139));
        System.out.println(customer.getAddress().toString());

    }
}