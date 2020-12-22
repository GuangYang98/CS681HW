package edu.umb.cs681.hw16;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class ThreadSafeObservable {
    private LinkedList<ThreadSafeObserver> observers;
    private AtomicBoolean changed;
    private ReentrantLock lock = new ReentrantLock();

    public ThreadSafeObservable(){
        observers = new LinkedList<ThreadSafeObserver>();
        changed = new AtomicBoolean(false);
    }

    public void addObserver(ThreadSafeObserver o){
        if(o == null) throw new NullPointerException();
        lock.lock();
        try{
            observers.add(o);
        }finally {
            lock.unlock();
        }

    }

    public void deleteObserver(ThreadSafeObservable o){
        lock.lock();
        try{
            if(observers.remove(o)){
                System.out.println("Removed");
            }else {
                System.out.println("Observer not exsist");
            }
        }finally {
            lock.unlock();
        }

    }

    protected void setChanged(){
        changed.set(true);
    }
    protected void clearChanged(){
        changed.set(false);
    }

    public boolean hasChanged(){
        return changed.get();
    }

    public void notifyObservers(Object obj){
        if (!changed.get()) {
            return;
        }
        lock.lock();
        try{
            observers.forEach(o -> o.update(this, obj));
        }finally {
            lock.unlock();
        }

        clearChanged();
    }
}