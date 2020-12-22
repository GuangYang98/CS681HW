package edu.umb.cs681.hw14;

import java.util.concurrent.locks.ReentrantLock;

public class WithdrawRunnable implements Runnable {
    private ThreadSafeBankAccount account = null;
    private boolean done = false;
    private ReentrantLock tlock = new ReentrantLock();

    public WithdrawRunnable(ThreadSafeBankAccount account){
        this.account = account;
    }

    public void setDone(){
        tlock.lock();
        try{
            done = true;
        }
        finally {
            tlock.unlock();
        }
    }

    public void run(){
        while(true){
            tlock.lock();
            if(done) break;
            account.withdraw(1000);

            try{
                Thread.sleep(200);
            }catch (InterruptedException e) {
                System.out.println(e.toString());
                continue;
            }
        }
    }
}