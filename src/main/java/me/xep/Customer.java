package me.xep;

public class Customer implements SpecificRecords {
    private Integer customerID;
    private String customerName;

    public Customer(Integer ID, String name) {
        this.customerID = ID;
        this.customerName = name;
    }

    public Integer getID() {
        return customerID;
    }

    public String getName() {
        return customerName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}