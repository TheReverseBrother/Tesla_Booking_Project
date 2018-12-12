package com.mycompany.teslabooking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest
{

    @Test
    void getType()
    {
        Truck instance = new Truck("Ford","Transit",100,3,"181-CW-0123",10000,new Location(60.08,45.98),false,10.0);
        String result = instance.getType();
        String expected = "Truck";
        assertEquals(expected,result);
    }

    @Test
    void getMake()
    {
        Truck instance = new Truck("Ford","Transit",100,3,"181-CW-0123",10000,new Location(60.08,45.98),false,10.0);
        String result = instance.getMake();
        String expected = "Ford";
        assertEquals(expected,result);
    }

    @Test
    void getModel()
    {
        Truck instance = new Truck("Ford","Transit",100,3,"181-CW-0123",10000,new Location(60.08,45.98),false,10.0);
        String result = instance.getModel();
        String expected = "Transit";
        assertEquals(expected,result);
    }

    @Test
    void getMilesPerKH()
    {
        Truck instance = new Truck("Ford","Transit",100,3,"181-CW-0123",10000,new Location(60.08,45.98),false,10.0);
        double result = instance.getCostPerMile();
        double expected = 100;
        assertEquals(expected,result);
    }

    @Test
    void getSeats()
    {
        Truck instance = new Truck("Ford","Transit",100,3,"181-CW-0123",10000,new Location(60.08,45.98),false,10.0);
        int result = instance.getSeats();
        int expected = 3;
        assertEquals(expected,result);
    }

    @Test
    void getRegistration()
    {
        Truck instance = new Truck("Ford","Transit",100,3,"181-CW-0123",10000,new Location(60.08,45.98),false,10.0);
        String result = instance.getRegistration();
        String expected = "181-CW-0123";
        assertEquals(expected,result);
    }


    @Test
    void getMileage()
    {
        Truck instance = new Truck("Ford","Transit",100,3,"181-CW-0123",10000,new Location(60.08,45.98),false,10.0);
        double result = instance.getMileage();
        double expected = 10000;
        assertEquals(expected,result);
    }

    @Test
    void getLatitude()
    {
        Truck instance = new Truck("Ford","Transit",100,3,"181-CW-0123",10000,new Location(60.08,45.98),false,10.0);
        double result = instance.getLatitude();
        double expected = 45.98;
        assertEquals(expected,result);
    }

    @Test
    void getLongitude()
    {
        Truck instance = new Truck("Ford","Transit",100,3,"181-CW-0123",10000,new Location(60.08,45.98),false,10.0);
        double result = instance.getLongitude();
        double expected = 60.08;
        assertEquals(expected,result);
    }


    @Test
    void isInDepot()
    {
        Truck instance = new Truck("Ford","Transit",100,3,"181-CW-0123",10000,new Location(60.08,45.98),false,10.0);
        boolean result = instance.isInDepot();
        boolean expected = false;
        assertEquals(expected,result);

    }
}