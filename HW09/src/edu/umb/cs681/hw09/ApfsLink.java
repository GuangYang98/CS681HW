package edu.umb.cs681.hw09;
import java.time.LocalDateTime;

public class ApfsLink extends ApfsElement{

    private FSElement target;

    public ApfsLink(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, LocalDateTime lastModified, FSElement target){
        super(parent, name, size, creationTime, lastModified);
        this.target = target;
    }

    public boolean isDirectory(){
        return false;
    }

    public boolean isFile(){
        return false;
    }

    public boolean isLink(){
        return true;
    }

    public FSElement getTarget(){
        lock.lock();
        try {
            return target;
        }finally {
            lock.unlock();
        }
    }

    public void setTarget(FSElement target){
        lock.lock();
        try {
            this.target = target;
        }finally {
            lock.unlock();
        }
    }
}
