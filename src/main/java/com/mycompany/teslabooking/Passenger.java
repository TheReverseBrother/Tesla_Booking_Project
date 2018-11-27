package com.mycompany.teslabooking;

public class Passenger
{
    private String name;
    private static int totalCustomers;
    private String passengerID;
    private String email;
    private String phoneNumber;
    private Location home;

    public Passenger(String name, String email, String phoneNumber, Location home) {
        totalCustomers++;
        this.name = name;
        this.passengerID = "PSG-" +totalCustomers;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.home = home;
        totalCustomers++;
    }

    public String getName()
    {
        return name;
    }

    public static int getTotalCustomers()
    {
        return totalCustomers;
    }

    public String getPassengerID()
    {
        return passengerID;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public double getHomeLatitude()
    {
        return home.getLatitude();
    }
    
    public double getHomeLongitude()
    {
        return home.getLongitude();
    }

    public Location getHome()
    {
        return home;
    }

    @Override
    public String toString() {
        return "Passenger{" + "name=" + name + ", passengerID=" + passengerID + ", email=" + email + ", phoneNumber=" + phoneNumber + ", home=" + home + '}';
    }
    
    
    
}
