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

public class Main{

        /**
         * None of the code is this project used the Project skeleton code available on moodle
         * each part of this is of my own design.
         */
    static ArrayList<Vehicle> VehicleList = SetAndSave.vehiclesList();
    static ArrayList<Passenger> PassengerList = SetAndSave.PassengerList();
    static ArrayList<vehicleBooking> Bookings = SetAndSave.BookingList();
    public static void main(String[] args)
    {
        boolean running = true;
        SetAndSave.setCosts();
        System.out.println("----Welcome To Tesla----");
        while(running)
        {

        }
        System.out.println("Thank You Come Again Soon.");
//        displayPassengers(PassengerList);
//        displayBookings(Bookings);
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
//        System.out.println(car1.getLocation());
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


    public static void mainMenu()
    {

        System.out.println("Please Choose An Option:");
        System.out.println("(1):Passengers");
        System.out.println("(2):Bookings");
        System.out.println("(3):Vehicles");
        System.out.println("(4): Quit");
    }

    public static void passengerMenu()
    {
        System.out.println("Please Choose An Option:");
        System.out.println("(1):View All Passengers");
        System.out.println("(2):Add Passengers");
        System.out.println("(3):Remove Passenger");
        System.out.println("(4): Quit");
    }

    public static void vehicleMenu()
    {
        System.out.println("Please Choose An Option:");
        System.out.println("(1):View All Vehicles");
        System.out.println("(2):Add vehicle");
        System.out.println("(3):Quit");
    }
    public static void bookingsMenu()
    {
        System.out.println("Please Choose An Option:");
        System.out.println("(1):View All Bookings");
        System.out.println("(2):Add Booking");
        System.out.println("(3):Remove Booking");
        System.out.println("(4):Quit");
    }
    enum Mainmenu {Passengers,Bookings,Vehicles,Quit;}
    public static void mainMenuSelector()
    {
        Scanner keyboard = new Scanner(System.in);
        int input = keyboard.nextInt();
        Mainmenu options = Mainmenu.values()[input];
        switch(options)
        {
            case Passengers:
                passengerMenu();
                break;
            case Bookings:

                break;
            case Vehicles:
                vehicleMenu();
                break;
            case Quit:
                System.out.println("HI");
                break;
            default:
                System.out.println("Invalid Input.");

        }
    }
    enum GeneralMenu{View,Add,Remove,Quit;}
    public static void passengerMenuSelector()
    {
        Scanner keyboard = new Scanner(System.in);
        int input = keyboard.nextInt();
        GeneralMenu options = GeneralMenu.values()[input];
        switch(options)
        {
            case View:
                passengerMenu();
                break;
            case Add:

                break;
            case Remove:
                vehicleMenu();
                break;
            case Quit:
                System.out.println("HI");
                break;
            default:
                System.out.println("Invalid Input.");

        }
    }


    public static void vehicleMenuSelector()
    {
        Scanner keyboard = new Scanner(System.in);
        int input = keyboard.nextInt();
        GeneralMenu options = GeneralMenu.values()[input];
        switch(options)
        {
            case View:
                passengerMenu();
                break;
            case Add:

                break;
            case Remove:
                vehicleMenu();
                break;
            case Quit:
                System.out.println("HI");
                break;
            default:
                System.out.println("Invalid Input.");

        }
    }


    public static void bookingMenuSelector()
    {
        Scanner keyboard = new Scanner(System.in);
        int input = keyboard.nextInt();
        GeneralMenu options = GeneralMenu.values()[input];
        switch(options)
        {
            case View:
                passengerMenu();
                break;
            case Add:

                break;
            case Remove:
                vehicleMenu();
                break;
            case Quit:
                System.out.println("HI");
                break;
            default:
                System.out.println("Invalid Input.");

        }
    }

    public static void AddPassenger()
    {
        Scanner sc = new Scanner(System.in);
        String name,email,phone,

        System.out.println("Please Enter Passenger Name");

    }


}
