package edu.umb.cs681.hw12;

public final class Address{
    private final String street, city, state;
    private final int zipcode;

    public Address(String street, String city, String state, int zipcode){
        this.state = state;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public int getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getStreet() {
        return street;
    }

    public String toString(){
        return street + " " + city + " " + state + " " + zipcode;
    }

    public boolean equal(Address address){
        if (this.toString().equals(address.toString())){
            return true;
        }
        else{
            return false;
        }
    }

    public Address change(String street, String city, String state, int zipcode){
        return new Address(street, city, state, zipcode);
    }
}