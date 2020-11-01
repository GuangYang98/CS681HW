package edu.umb.cs681.hw10;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellableInterruptiblePrimeFactorizer extends RunnableCancellablePrimeFactorizer {
    private boolean done = false;
    private ReentrantLock lock = new ReentrantLock();

    public RunnableCancellableInterruptiblePrimeFactorizer(long dividend, long from, long to) {
        super(dividend, from, to);
    }

    public void setDone(){
        lock.lock();
        try{
            done = true;
        }finally {
            lock.unlock();
        }
    }

    public void generatePrimeFactors() {
        long divisor = from;
        while( dividend != 1 && divisor <= to ){
            lock.lock();
            try {
                if (done) { break; }
                if (divisor > 2 && isEven(divisor)) {
                    divisor++;
                    continue;
                }
                if (dividend % divisor == 0) {
                    factors.add(divisor);
                    dividend /= divisor;
                } else {
                    if (divisor == 2) {
                        divisor++;
                    } else {
                        divisor += 2;
                    }
                }
            } finally {
                lock.unlock();
            }
            try{
                Thread.sleep(10);
            } catch(InterruptedException e) {
                continue;
            }
        }
    }

    public static void main(String[] args){
        RunnableCancellableInterruptiblePrimeFactorizer factor = new RunnableCancellableInterruptiblePrimeFactorizer(7382642974L,2, (long)Math.sqrt(7382642974L));
        Thread thread = new Thread(factor);
        System.out.println("get the Factorization from 2 to 7382642974");
        thread.start();
        factor.setDone();
        try{
            thread.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final result: " + factor.getPrimeFactors() + "\n");

    }
}
