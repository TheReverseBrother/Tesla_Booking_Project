package com.mycompany.teslabooking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest
{
    @Test
    void getCostpermileCar()
    {
        Car instance = new Car("Ford","Transit",100,3,"181-CW-0123",10000,new Location(60.08,45.98),false);
        double result = instance.getCostPerMile();
        double expected = 0;
        assertEquals(expected,result);
    }

    @Test
    void setCostpermileCar()
    {
        Car instance = new Car("Ford","Transit",100,3,"181-CW-0123",10000,new Location(60.08,45.98),false);
        instance.setCostPerMile(200);
        double result = instance.getCostPerMile();
        double expected = 200;
        assertEquals(expected,result);
    }
}