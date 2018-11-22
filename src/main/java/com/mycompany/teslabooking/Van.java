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
public class Van extends Vehicle
{
    private double vanLoadSpace;
    static double costpermileVan;

    public Van(double vanLoadSpace, String make, String model, int milesPerKH, int seats, String registration, double mileage, Location location, boolean inDepot)
    {
        super("Van",make, model, milesPerKH, seats, registration, costpermileVan, mileage, location, inDepot);
        this.vanLoadSpace = vanLoadSpace;
    }

    public double getVanLoadSpace() {
        return vanLoadSpace;
    }

    public static double getCostpermileVan()
    {
        return costpermileVan;
    }

    public static void setCostpermileVan(double costpermileVan)
    {
        Van.costpermileVan = costpermileVan;
    }
    
    
}
