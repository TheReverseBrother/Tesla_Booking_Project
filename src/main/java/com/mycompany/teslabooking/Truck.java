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
public class Truck extends Vehicle
{
    private double loadspaceTruck;
    static double costpermileTruck;

    public Truck( String make, String model, int milesPerKH, int seats, String registration, double mileage, Location location, boolean inDepot, double loadspaceTruck)
    {
        super("Truck", make, model, milesPerKH, seats, registration, costpermileTruck, mileage, location, inDepot);
        this.loadspaceTruck = loadspaceTruck;
    }
    @Override
    public double getLoadSpace() {
        return loadspaceTruck;
    }

    public static double getCostpermileTruck() {
        return costpermileTruck;
    }

    public static void setCostpermileTruck(double costpermileTruck) {
        Truck.costpermileTruck = costpermileTruck;
    }
}
