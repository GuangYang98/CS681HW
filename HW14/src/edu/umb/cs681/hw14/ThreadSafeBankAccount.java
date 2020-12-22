package edu.umb.cs681.hw14;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class ThreadSafeBankAccount implements Account{
    private double balance = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition sufficientFundsCondition = lock.newCondition();
    private Condition belowUpperLimitFundsCondition = lock.newCondition();

    public void deposit(double amount){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getId() + " deposit. Current balance: " + balance);
            while(balance >= 500){
                System.out.println(Thread.currentThread().getId() + " deposit. Balance exceeds the upper limit!");
                belowUpperLimitFundsCondition.await();
            }
            balance += amount;
            System.out.println(Thread.currentThread().getId() + " deposit. New balance: " + balance);
            sufficientFundsCondition.signalAll();
        }
        catch (InterruptedException exception){
            exception.printStackTrace();
        }
        finally{
            lock.unlock();
        }
    }

    public void withdraw(double amount){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getId() + " withdraw. Current balance: " + balance);
            while(balance <= 0){
                System.out.println(Thread.currentThread().getId() + " withdraw. Insufficient funds!");
                sufficientFundsCondition.await();
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getId() + " withdraw. New balance: " + balance);
            belowUpperLimitFundsCondition.signalAll();
        }
        catch (InterruptedException exception){
            exception.printStackTrace();
        }
        finally{
            lock.unlock();
        }
    }

    public static void main(String[] args){
        ThreadSafeBankAccount bankAccount = new ThreadSafeBankAccount();
        for(int i = 0; i < 5; i++){
            new Thread( new DepositRunnable(bankAccount) ).start();
            new Thread( new WithdrawRunnable(bankAccount) ).start();
        }
    }
}
