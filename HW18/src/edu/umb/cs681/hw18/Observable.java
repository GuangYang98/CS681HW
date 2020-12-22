package edu.umb.cs681.hw18;
import java.util.LinkedList;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class Observable {
    private ConcurrentLinkedQueue<Observer> observers;
    private AtomicBoolean changed = new AtomicBoolean(false); //new added

    public Observable () {
        observers = new ConcurrentLinkedQueue<Observer>();
    }

    public void addObserver(Observer o) {
        this.observers.offer(o);
    }

    public void deleteObserver(Observer o) {
        this.observers.remove(o);
    }

    protected void setChanged() {
        changed.set(true);
    }

    protected void clearChanged() {
        changed.set(false);
    }

    public boolean hasChanged() {
        return changed.get();
    }

    public void notifyObservers(Object obj) {
        if (hasChanged()) {
            observers.forEach(observer -> observer.update(this, obj));
            clearChanged();
        }
    }

    public int countObservers() {
        return observers.size();
    }
}