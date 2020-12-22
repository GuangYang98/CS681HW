package edu.umb.cs681.hw14;

import java.util.concurrent.locks.ReentrantLock;

public class DepositRunnable implements Runnable {
    private Account account;
    private volatile boolean done = false;
    private ReentrantLock tlock = new ReentrantLock();

    public DepositRunnable(Account account){
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
            if (done)break;
            account.deposit(1000);
            try{
                Thread.sleep(200);
            }catch (InterruptedException e) {
                System.out.println(e.toString());
                continue;
            }
        }
    }



}