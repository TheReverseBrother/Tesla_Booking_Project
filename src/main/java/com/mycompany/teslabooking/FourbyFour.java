/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teslabooking;

/**
 *
 * @author Tomas
 */
public class FourbyFour extends Vehicle
{
    //Cost per mile is initialised by the initial constructer and price is saved to a file of its own
    static double costpermileFourbyFour;

    public FourbyFour(String make, String model, int milesPerKH, int seats, String registration, double mileage, Location location, boolean inDepot) {
        super(make, model, milesPerKH, seats, registration, costpermileFourbyFour, mileage, location, inDepot);
    }
    
}
