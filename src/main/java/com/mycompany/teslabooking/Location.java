package com.mycompany.teslabooking;

/**
 *
 * @author Tomas
 */
public class Location 
{
    private double longitude;
    private double latitude;

    public Location(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public double getLatitude()
    {
        return latitude;
    }

    @Override
    public String toString()
    {
        return " " + longitude + ", " + latitude;
    }
    
    
}
