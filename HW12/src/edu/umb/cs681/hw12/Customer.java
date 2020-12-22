package edu.umb.cs681.hw12;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.atomic.AtomicReference;

public class Customer {
    private AtomicReference<Address> address;
    private ReentrantLock lock = new ReentrantLock();

    public Customer(Address addr) {
        address = new AtomicReference<>(addr);
    }


    public void setAddress(Address addr) {
        lock.lock();
        try{
            address.set(addr);
        }
        finally {
            lock.unlock();
        }

    }

    public Address getAddress() {
        lock.lock();
        try {
            return this.address.get();
        }
        finally {
            lock.unlock();
        }
    }
}