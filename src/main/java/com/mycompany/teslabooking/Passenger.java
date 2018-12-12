package com.mycompany.teslabooking;

import java.util.Objects;

public class Passenger
{
    private String name;
    private static int totalCustomers;
    private String passengerID;
    private String email;
    private String phoneNumber;
    private Location home;

    public Passenger(String name, String email, String phoneNumber, Location home)
    {
        totalCustomers++;
        this.name = name;
        this.passengerID = "PSG-" +totalCustomers;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.home = home;
    }

    public Passenger(String name, String passengerID, String email, String phoneNumber, Location home)
    {
        this.name = name;
        this.passengerID = passengerID;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.home = home;
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

    public void setName(String name)
    {
        this.name = name;
    }

    public static void setTotalCustomers(int totalCustomers)
    {
        Passenger.totalCustomers = totalCustomers;
    }

    public void setPassengerID(String passengerID)
    {
        this.passengerID = passengerID;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public void setHome(Location home)
    {
        this.home = home;
    }

    @Override
    public String toString() {
        return "Passenger{" + "name=" + name + ", passengerID=" + passengerID + ", email=" + email + ", phoneNumber=" + phoneNumber + ", home=" + home + '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(name, passenger.name) &&
                Objects.equals(passengerID, passenger.passengerID) &&
                Objects.equals(email, passenger.email) &&
                Objects.equals(phoneNumber, passenger.phoneNumber) &&
                Objects.equals(home, passenger.home);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, passengerID, email, phoneNumber, home);
    }
}
