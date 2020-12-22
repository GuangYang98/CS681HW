package edu.umb.cs681.hw17;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Random;
import java.util.ArrayList;


public class RequestHandler implements Runnable{
    private ReentrantLock tlock = new ReentrantLock();
    private boolean done = false;
    private AccessCounter counter = AccessCounter.getInstance();
    private static ArrayList<Path> path = new ArrayList<Path>();

    public void setDone(){
        tlock.lock();
        try{
            done = true;
        }finally {
            tlock.unlock();
        }
    }

    public void run(){
        Random random = new Random();

        while(true){
            tlock.lock();
            try{
                if (done) break;
            }finally {
                tlock.unlock();
            }

            Path file = path.get(random.nextInt(path.size()));
            AccessCounter.getInstance().increment(file);
            AccessCounter.getInstance().getCount(file);

            try{
                Thread.sleep(2000);
            }catch (InterruptedException e) {
                continue;
            }
        }

    }


    public static void main(String[] args){
        //paths?
        path.add(Paths.get("a.html"));
        path.add(Paths.get("b.html"));
        path.add(Paths.get("c.html"));
        path.add(Paths.get("d.html"));

        ArrayList<Thread> thread = new ArrayList<>();
        RequestHandler handler1 = new RequestHandler();
        RequestHandler handler2 = new RequestHandler();
        RequestHandler handler3 = new RequestHandler();
        RequestHandler handler4 = new RequestHandler();
        RequestHandler handler5 = new RequestHandler();
        RequestHandler handler6 = new RequestHandler();
        RequestHandler handler7 = new RequestHandler();
        RequestHandler handler8 = new RequestHandler();
        RequestHandler handler9 = new RequestHandler();
        RequestHandler handler10 = new RequestHandler();
        RequestHandler handler11 = new RequestHandler();
        RequestHandler handler12 = new RequestHandler();


        Thread thread1 = new Thread(handler1);
        Thread thread2 = new Thread(handler2);
        Thread thread3 = new Thread(handler3);
        Thread thread4 = new Thread(handler4);
        Thread thread5 = new Thread(handler5);
        Thread thread6 = new Thread(handler6);
        Thread thread7 = new Thread(handler7);
        Thread thread8 = new Thread(handler8);
        Thread thread9 = new Thread(handler9);
        Thread thread10 = new Thread(handler10);
        Thread thread11 = new Thread(handler11);
        Thread thread12 = new Thread(handler12);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
        thread11.start();
        thread12.start();

        try {
            Thread.sleep(2000);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }

        handler1.setDone();
        handler2.setDone();
        handler3.setDone();
        handler4.setDone();
        handler5.setDone();
        handler6.setDone();
        handler7.setDone();
        handler8.setDone();
        handler9.setDone();
        handler10.setDone();
        handler11.setDone();
        handler12.setDone();

        thread1.interrupt();
        thread2.interrupt();
        thread3.interrupt();
        thread4.interrupt();
        thread5.interrupt();
        thread6.interrupt();
        thread7.interrupt();
        thread8.interrupt();
        thread9.interrupt();
        thread10.interrupt();
        thread11.interrupt();
        thread12.interrupt();

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
            thread10.join();
            thread11.join();
            thread12.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }



}