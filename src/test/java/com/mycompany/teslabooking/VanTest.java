package com.mycompany.teslabooking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VanTest
{

    @Test
    void getLoadSpace()
    {
        Van instance = new Van("Ford","Transit",100,3,"181-CW-0123",10000,new Location(60.08,45.98),false,10.0);
    }
    @Test
    void getCostpermileVan()
    {
        Van instance = new Van("Ford","Transit",100,3,"181-CW-0123",10000,new Location(60.08,45.98),false,10.0);
        double result = instance.getCostPerMile();
        double expected = 0;
        assertEquals(expected,result);
    }

    @Test
    void setCostpermileVan()
    {
        Van instance = new Van("Ford","Transit",100,3,"181-CW-0123",10000,new Location(60.08,45.98),false,10.0);
        instance.setCostPerMile(200);
        double result = instance.getCostPerMile();
        double expected = 200;
        assertEquals(expected,result);
    }
}