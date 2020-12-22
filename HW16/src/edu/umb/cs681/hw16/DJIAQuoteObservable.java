package edu.umb.cs681.hw16;

public class DJIAQuoteObservable extends ThreadSafeObservable{
    public void setQuote(){
        this.setChanged();
    }
}