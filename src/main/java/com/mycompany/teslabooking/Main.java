/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teslabooking;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main

        /**
         * None of the code is this project used the Project skeleton code available on moodle
         * each part of this is of my own design.
         */
{
    public ArrayList<Vehicle> VehicleList = new ArrayList<Vehicle>();
    ArrayList<Passenger> PassengerList = new ArrayList<Passenger>();
    ArrayList<vehicleBooking> Bookings = new ArrayList<vehicleBooking>();


    public static void main(String[] args) throws FileNotFoundException
    {
        SetAndSave.setCosts();
        ArrayList<Vehicle> VehicleList = new ArrayList<Vehicle>();
        Car car1 = new Car("1","1",1,1,"11",
                1,new Location(2.0,2.0), false);

        System.out.println(car1.getType());
        System.out.println(car1.getCostPerMile());
        //writeTofile(VehicleList);
        readFromFile();
        SetAndSave.saveCosts();
    }

    public void createBooking()
    {

    }

    public void displayBookings()
    {

    }

    public void displayPassengers()
    {

    }

    public void displayVehicles()
    {

    }

    public void addPassenger()
    {

    }

    public static void writeTofile(ArrayList<Vehicle> VehicleList)
    {
        try(FileWriter costFile = new FileWriter("carCost.txt"))
        {
            for(int i = 0; i <VehicleList.size(); i++){
                costFile.write( "CUNT FACE TWAT" + "\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public static void readFromFile() throws FileNotFoundException
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
}
