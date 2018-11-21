package com.mycompany.teslabooking;

public class Passenger
{
    private String name;
    private static int totalCustomers;
    private int customerID;
    private String email;
    private int phoneNumber;
    private Location home;

    public Passenger(String name, int customerID, String email, int phoneNumber, Location home) {
        this.name = name;
        this.customerID = customerID;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.home = home;
    }

    public String getName() {
        return name;
    }

    public static int getTotalCustomers() {
        return totalCustomers;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public double getHomeLatitude() {
        return home.getLatitude();
    }
    
    public double getHomeLongitude() {
        return home.getLongitude();
    }

    public Location getHome() {
        return home;
    }

    @Override
    public String toString() {
        return "Passenger{" + "name=" + name + ", customerID=" + customerID + ", email=" + email + ", phoneNumber=" + phoneNumber + ", home=" + home + '}';
    }
    
    
    
}
