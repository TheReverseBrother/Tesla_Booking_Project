package com.mycompany.teslabooking;

public class Vehicle
{
    private String type;
    private String make;
    private String model;
    private int milesPerKH;
    private int seats;
    private String registration;
    private double costPerMile;
    private double mileage;
    private Location location;
    private boolean inDepot;

    public Vehicle(String type, String make, String model, int milesPerKH, int seats, String registration, double costPerMile, double mileage, Location location, boolean inDepot)
    {
        this.type = type;
        this.make = make;
        this.model = model;
        this.milesPerKH = milesPerKH;
        this.seats = seats;
        this.registration = registration;
        this.costPerMile = costPerMile;
        this.mileage = mileage;
        this.location = location;
        this.inDepot = inDepot;
    }

    public String getType()
    {
        return type;
    }

    public String getMake()
    {

        return make;
    }

    public String getModel()
    {

        return model;
    }

    public int getMilesPerKH()
    {

        return milesPerKH;
    }

    public int getSeats()
    {
        return seats;
    }

    public String getRegistration()
    {
        return registration;
    }

    public double getCostPerMile()
    {
        return costPerMile;
    }

    public double getMileage()
    {
        return mileage;
    }

    public void setCostPerMile(double costPerMile)
    {
        this.costPerMile = costPerMile;
    }

    public Location getLocation()
    {
        return location;
    }

    public boolean isInDepot()
    {
        return inDepot;
    }

    public void setMileage(double mileage)
    {
        this.mileage = mileage;
    }

    public void setLocation(Location location)
    {
        this.location = location;
    }

    public void setInDepot(boolean inDepot)
    {
        this.inDepot = inDepot;
    }

   
}
