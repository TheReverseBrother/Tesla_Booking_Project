package com.mycompany.teslabooking;

public class Van extends Vehicle
{
    private double vanLoadSpace;
    static double costpermileVan;

    public Van( String make, String model, int milesPerKH,
               int seats, String registration, double mileage, Location location, boolean inDepot, double vanLoadSpace)
    {
        super("Van",make, model, milesPerKH, seats, registration, costpermileVan, mileage, location, inDepot);
        this.vanLoadSpace = vanLoadSpace;
    }
    @Override
    public double getLoadSpace() {
        return vanLoadSpace;
    }

    public static double getCostpermileVan()
    {
        return costpermileVan;
    }

    public static void setCostpermileVan(double costpermile)
    {
        Van.costpermileVan = costpermile;
    }
    
    
}
