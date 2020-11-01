package edu.umb.cs681.hw09;

//import edu.umb.cs681.hw09.FSElement;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class ApfsElement extends FSElement{

    private LocalDateTime lastModified;
    private LinkedList<ApfsElement> ApfsChildren = new LinkedList<ApfsElement>();

    public ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, LocalDateTime lastModified){
        super(parent, name, size, creationTime);
        this.lastModified = lastModified;
    }

    public int getSize() {
        lock.lock();
        try {
            return this.size;
        }finally {
            lock.unlock();
        }
    }

    public LocalDateTime getLastModified(){
        lock.lock();
        try {
            return lastModified;
        }finally {
            lock.unlock();
        }
    }

    public void setLastModified(){
        lock.lock();
        try {
            this.lastModified = lastModified;
        }finally {
            lock.unlock();
        }
    }

    public LinkedList<ApfsElement> getChildren(){
        return this.ApfsChildren;
    }

    public void appendChild(FSElement child){
        this.ApfsChildren.add((ApfsElement) child);
    }

    public boolean isDirectory(){
        return false;
    }

    public boolean isFile(){
        return false;
    }

    public boolean isLink(){
        return false;
    }
}
