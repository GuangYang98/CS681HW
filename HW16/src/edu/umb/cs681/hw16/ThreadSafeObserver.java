package edu.umb.cs681.hw16;

@FunctionalInterface
public interface ThreadSafeObserver {
    public void update(ThreadSafeObservable obs, Object obj);
}