package com.mycompany.teslabooking;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class SetAndSave
{
    public static void setCosts() throws FileNotFoundException
    {
        File inputFile = new File("carCost.txt");

        //link Scanner object with the File
        Scanner input = new Scanner(inputFile);
        double number;
        double average;
        int total = 0;
        int count = 0;

        while (input.hasNext())          // more values in file?
        {
            //number = input.nextDouble();
            Car.setCostpermileCar(input.nextDouble());
            Van.setCostpermileVan(input.nextDouble());// read next intege
            FourbyFour.setCostpermileFourbyFour(input.nextDouble());
            Truck.setCostpermileTruck(input.nextDouble());
            //System.out.println(number);
        }
        System.out.println(Car.getCostpermileCar());
        System.out.println(Van.getCostpermileVan());
        System.out.println(FourbyFour.getCostpermileFourbyFour());
        System.out.println(Truck.getCostpermileTruck());
        System.out.println(Van.getCostpermileVan());
    }
    public static void saveCosts()
    {
        try(FileWriter costFile = new FileWriter("carCost.txt"))
        {
            costFile.write("2.00" + "\n");
            costFile.write("2.00" + "\n");
            costFile.write("2.00"+ "\n");
            costFile.write("2.00"+ "\n");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void setVehicles(ArrayList<Vehicle> VehicleList) throws FileNotFoundException
    {
        File inputFile = new File("vehicles.txt");
        Scanner input = new Scanner(inputFile);
        while(input.hasNext())
        {
            String type = input.next();

            String make = input.next();
            String model = input.next();
            int milesPerKH = input.nextInt();
            int seats = input.nextInt();
            String registration = input.next();
            double mileage = input.nextDouble();
            double latitude = input.nextDouble();
            double longitude = input.nextDouble();
            boolean inDepot = input.nextBoolean();

            if(type == "Car")
            {
                VehicleList.add(new Car(make, model, milesPerKH, seats,
                        registration, mileage, new Location(latitude, longitude), inDepot));
            }
            else if(type == "Van")
            {
                double loadspace = input.nextDouble();
                VehicleList.add(new Van(make, model, milesPerKH,
                        seats, registration, mileage, new Location(latitude, longitude), inDepot, loadspace));
            }
            else if(type == "Truck")
            {
                double loadspace = input.nextDouble();
                VehicleList.add(new Truck(make, model, milesPerKH,
                        seats, registration, mileage, new Location(latitude, longitude), inDepot, loadspace));
            }
            else if(type == "4x4")
            {
                VehicleList.add(new FourbyFour(make, model, milesPerKH,
                        seats, registration, mileage, new Location(latitude, longitude), inDepot));
            }
            else
            {
                System.out.println("Error");
                break;
            }
        }
    }
}
