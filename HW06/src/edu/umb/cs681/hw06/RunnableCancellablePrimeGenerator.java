package edu.umb.cs681.hw06;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellablePrimeGenerator extends RunnablePrimeGenerator {
    private boolean done = false;
    private ReentrantLock lock = new ReentrantLock();
    public RunnableCancellablePrimeGenerator(long from, long to) {
        super(from, to);
    }

    public void setDone(){
        done = true;
    }

    public void generatePrimes(){
        for (long n = from; n <= to; n++) {
            lock.lock();
            // Stop generating prime numbers if done==true
            try{
                if(done){
                    System.out.println("Stopped generating prime numbers.");
                    break;
                }
                if(isPrime(n)){
                    this.primes.add(n);
                }
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        RunnableCancellablePrimeGenerator gen = new RunnableCancellablePrimeGenerator(1,200);
        Thread thread = new Thread(gen);
        thread.start();
        gen.setDone();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gen.getPrimes().forEach( (Long prime)-> System.out.print(prime + ", ") );
        System.out.println();
        System.out.println("Found " + gen.getPrimes().size() + " numbers.");
    }
}