package com.mycompany.teslabooking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TruckTest
{

    @Test
    void getLoadSpace()
    {
        Truck instance = new Truck("Ford","Transit",100,3,"181-CW-0123",10000,new Location(60.08,45.98),false,10.0);
        double result = instance.getLoadSpace();
        double expected = 10.0;
        assertEquals(expected,result);
    }

    @Test
    void getCostpermileTruck()
    {
        Truck instance = new Truck("Ford","Transit",100,3,"181-CW-0123",10000,new Location(60.08,45.98),false,10.0);
        double result = instance.getCostPerMile();
        double expected = 0;
        assertEquals(expected,result);
    }

    @Test
    void setCostpermileTruck()
    {
        Truck.setCostpermileTruck(200);
        Truck instance = new Truck("Ford","Transit",100,3,"181-CW-0123",10000,new Location(60.08,45.98),false,10.0);

        double result = instance.getCostPerMile();
        double expected = 200;
        assertEquals(expected,result);
    }
}