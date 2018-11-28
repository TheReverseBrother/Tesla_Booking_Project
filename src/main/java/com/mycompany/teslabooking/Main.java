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
import java.util.Set;
import java.util.Formattable;

public class Main

        /**
         * None of the code is this project used the Project skeleton code available on moodle
         * each part of this is of my own design.
         */
{


    public static void main(String[] args)
    {
        SetAndSave.setCosts();
        ArrayList<Vehicle> VehicleList = SetAndSave.vehiclesList();
        ArrayList<Passenger> PassengerList = SetAndSave.PassengerList();
        ArrayList<vehicleBooking> Bookings = SetAndSave.BookingList();

//        displayPassengers(PassengerList);
        displayBookings(Bookings);
//        SetAndSave.saveCosts();


//        Car car1 = new Car("BOOM","1",1,1,"11",
//                1,new Location(2.0,2.0), false);
//
//        VehicleList.add(car1);
//        for(int i = 0; i<VehicleList.size(); i++)
//        {
//            System.out.println(VehicleList[i].getMake());
//        }

//        System.out.println(car1.getType());
//        System.out.println(car1.isInDepot());
////        System.out.println(car1.getLocation());
//        readFromFile();
        SetAndSave.saveCosts();
        SetAndSave.saveVehicles(VehicleList);
        SetAndSave.savePassengers(PassengerList);
        SetAndSave.saveBookings(Bookings);
    }

    public void createBooking()
    {

    }

    public static void displayBookings(ArrayList<vehicleBooking> Bookings)
    {
        String passengerID,bookingnumber,bookingDT,startLocation,endLocation,vehicleBooked,cost;

        String format = "|%1$-15s|%2$-25s|%3$-25s|%4$-20s|%5$-20s|%6$-20s|%7$-10s|\n";
        System.out.println("_________________________________________________________________________________________________________________________________________________________________");
        System.out.println("|_______________________________________________________________________________________________________________________________________________________________|");
        System.out.format(format,"PassengerID","Booking Number","Booking Date","Start Location","End Location","Vehicle Booked","Cost");
        for(int i = 0; i <Bookings.size();i++)
        {
            passengerID = Bookings.get(i).getPassengerID();
            bookingnumber = "" +Bookings.get(i).getBookingnumber();
            bookingDT = "" +Bookings.get(i).getBookingDT();
            startLocation = ""+ Bookings.get(i).getStartLocation();
            endLocation = "" + Bookings.get(i).getEndLocation();
            vehicleBooked = ""+ Bookings.get(i).getVehicleBooked();
            cost = ""+Bookings.get(i).getBookingCost();
            System.out.format(format, passengerID, bookingnumber, bookingDT,startLocation,endLocation,vehicleBooked,cost);
        }
        System.out.println("|________________________________________________________________________" +
                "_______________________________________________________________________________________|");

    }

    public static void displayPassengers(ArrayList<Passenger> PassengerList)
    {
        String passengerID,name,email,phoneNo,home;

        String format = "|%1$-15s|%2$-20s|%3$-25s|%4$-35s|%5$-34s|\n";
        System.out.println("_______________________________________________" +
                "__________________________________________________________________________________________________________________");
        System.out.println("|_________________________________________________________" +
                "______________________________________________________________________________________________________|");
        System.out.format(format,"PassengerID","Booking Number","Booking Date","Start Location","End Location","Vehicle Booked");
        for(int i = 0; i <PassengerList.size();i++)
        {
            passengerID = PassengerList.get(i).getPassengerID();
            name = "" +PassengerList.get(i).getName();
            email = "" +PassengerList.get(i).getEmail();
            phoneNo = ""+ PassengerList.get(i).getPhoneNumber();
            home = "" + PassengerList.get(i).getHome();
            System.out.format(format, passengerID, name, email,phoneNo,home);
        }
        System.out.println("|________________________________________________________________________" +
                "_______________________________________________________________________________________|");
    }

    public void displayVehicles(ArrayList<Vehicle> vehicleList,String selected)
    {

    }

    public void addPassenger()
    {

    }

//    public static void writeTofile(ArrayList<Vehicle> VehicleList)
//    {
//        try(FileWriter costFile = new FileWriter("carCost.txt"))
//        {
//            for(int i = 0; i <VehicleList.size(); i++){
//                costFile.write( "CUNT FACE TWAT" + "\n");
//            }
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//    }
//
//    public static void readFromFile() throws FileNotFoundException
//    {
//        File inputFile = new File("carCost.txt");
//
//        //link Scanner object with the File
//        Scanner input = new Scanner(inputFile);
//        double number;
//        double average;
//        int total = 0;
//        int count = 0;
//
//        while (input.hasNext())          // more values in file?
//        {
//            //number = input.nextDouble();
//            Car.setCostpermileCar(input.nextDouble());
//            Van.setCostpermileVan(input.nextDouble());// read next intege
//            FourbyFour.setCostpermileFourbyFour(input.nextDouble());
//            Truck.setCostpermileTruck(input.nextDouble());
//            //System.out.println(number);
//        }
//        System.out.println(Car.getCostpermileCar());
//        System.out.println(Van.getCostpermileVan());
//        System.out.println(FourbyFour.getCostpermileFourbyFour());
//        System.out.println(Truck.getCostpermileTruck());
//        System.out.println(Van.getCostpermileVan());
//
//    }
}
