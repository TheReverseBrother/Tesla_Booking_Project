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
public class Car extends Vehicle
{
    static double costpermileCar;

    public Car(String make, String model, int milesPerKH, int seats, String registration, double mileage, Location location, boolean inDepot) {
        super("Car",make, model, milesPerKH, seats, registration, costpermileCar, mileage, location, inDepot);
    }

    public static double getCostpermileCar() {
        return costpermileCar;
    }

    public static void setCostpermileCar(double costpermileCar) {
        Car.costpermileCar = costpermileCar;
    }
    
    
}
