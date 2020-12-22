package edu.umb.cs681.hw13;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter{

    private  HashMap<Path,Integer> hashmap = new HashMap<>();
    private  ReentrantLock tlock = new ReentrantLock();
    private  static ReentrantLock entrantlock = new ReentrantLock();
    private static AccessCounter instance = null;

    private AccessCounter(){}

    public void increment(Path path){
        tlock.lock();
        try{
            if (hashmap.containsKey(path)){
                hashmap.put(path, hashmap.get(path)+1);
            }else{
                hashmap.put(path, 1);
            }

        }finally {
            tlock.unlock();
        }
    }

    public int getCount(Path path){
        tlock.lock();
        try{
            if (hashmap.containsKey(path)){
                return hashmap.get(path);
            }
            else{
                return 0;
            }
        }finally {
            tlock.unlock();
        }
    }

    public static AccessCounter getInstance(){
        entrantlock.lock();
        try{
            if (instance == null){
                instance = new AccessCounter();
            }
        }
        finally {
            entrantlock.unlock();
        }
        return instance;
    }
}