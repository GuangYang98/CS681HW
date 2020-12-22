package edu.umb.cs681.hw15;

import javax.management.monitor.Monitor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AdmissionMonitor {
    private int currentVisitors = 0;
    private ReentrantLock tlock = new ReentrantLock();
    private boolean done = false;
    private Condition MaxCondition = tlock.newCondition();
    private Condition MinCondition = tlock.newCondition();

    public int countCurrentVisitors(){
        tlock.lock();
        try{
            return currentVisitors;
        }finally {
            tlock.unlock();
        }
    }
    public void enter(){
        tlock.lock();
        while(currentVisitors >= 5){
            try{
                System.out.println("Too many visitors. Please wait for a while!");
                MaxCondition.await();
            }
            catch (InterruptedException e) {
                return;
            }
        }
        currentVisitors ++;
        MinCondition.signalAll();
        tlock.unlock();
    }

    public void exit(){
        while (currentVisitors <= 0){
            try{
                MinCondition.await();
            }catch (InterruptedException e){
                System.out.println(e);
            }
            currentVisitors--;
            MaxCondition.signalAll();
            tlock.unlock();
        }
    }

    public static void main(String[] args){
        AdmissionMonitor monitor = new AdmissionMonitor();
        MonitorHandler watch = new MonitorHandler(monitor);

        EntranceHandler entr1 = new EntranceHandler(monitor);
        EntranceHandler entr2 = new EntranceHandler(monitor);
        EntranceHandler entr3 = new EntranceHandler(monitor);
        EntranceHandler entr4 = new EntranceHandler(monitor);

        ExitHandler exit1 = new ExitHandler(monitor);
        ExitHandler exit2 = new ExitHandler(monitor);
        ExitHandler exit3 = new ExitHandler(monitor);
        ExitHandler exit4 = new ExitHandler(monitor);

        Thread thread1 = new Thread(entr1);
        Thread thread2 = new Thread(entr2);
        Thread thread3 = new Thread(entr3);
        Thread thread4 = new Thread(entr4);
        Thread thread5 = new Thread(exit1);
        Thread thread6 = new Thread(exit2);
        Thread thread7 = new Thread(exit3);
        Thread thread8 = new Thread(exit4);
        Thread thread9 = new Thread(watch);

        thread9.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();

        try {
            Thread.sleep(100);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }

        entr1.setDone();
        entr2.setDone();
        entr3.setDone();
        entr4.setDone();
        exit1.setDone();
        exit2.setDone();
        exit3.setDone();
        exit4.setDone();
        watch.setDone();

        thread1.interrupt();
        thread2.interrupt();
        thread3.interrupt();
        thread4.interrupt();
        thread5.interrupt();
        thread6.interrupt();
        thread7.interrupt();
        thread8.interrupt();
        thread9.interrupt();

        try{
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
            thread8.join();
            thread9.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
