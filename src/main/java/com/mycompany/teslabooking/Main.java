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
        static {SetAndSave.setCosts();}
        public static ArrayList<Vehicle> VehicleList = SetAndSave.vehiclesList();
        public static ArrayList<Passenger> PassengerList = SetAndSave.PassengerList();
        public static ArrayList<vehicleBooking> Bookings = SetAndSave.BookingList();

    public static void main(String[] args)
    {
        boolean running = true;
        while(running) {
            running = Menus.mainMenu();
        }
//        DisplaySettings.displayAllVehicles(VehicleList);



        SetAndSave.saveCosts();
        SetAndSave.saveVehicles(VehicleList);
        SetAndSave.savePassengers(PassengerList);
        SetAndSave.saveBookings(Bookings);

    }


    public static void PassengerSelector(ArrayList<Passenger> PassengerList)
    {
        String name,email,selector;

        String format = "|%1$-15s|%2$-20s|%3$-25s|\n";
        System.out.println("_____________________________________________________________________________________________________________________________________");
        System.out.println("|_________________________________________________________" +
                "____________________________________________________________________________|");
        System.out.format(format,"PassengerID","Name","Email","PhoneNo:","Home Location");
        for(int i = 0; i <PassengerList.size();i++)
        {
            int j = i +1;
            selector = "("+j+")";
            name = "" +PassengerList.get(i).getName();
            email = "" +PassengerList.get(i).getEmail();
            System.out.format(format, selector, name, email);
        }
        System.out.println("|_____________________________________________________________________________________________________________________________________|");
    }

    public static String selectCurrentPassenger()
    {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        int input = 0;
        String psgID ="";
        while(running)
        {
            PassengerSelector(PassengerList);
            System.out.println("Please Select Passenger:");
             input = sc.nextInt();
            if( input <= PassengerList.size() && input > 0)
            {
                psgID = PassengerList.get(input - 1).getPassengerID();
                running = false;
            }
            else{
                System.out.println("Please Enter valid Number");
            }
        }
        return psgID;
    }
    enum Type {Car,FourByFour,Truck,Van,All}

    public static String VehicleSelect()
    {
        Scanner keyboard = new Scanner(System.in);
        boolean running = true;
        String type = "";
        while (running)
        {
            System.out.println("(1): Car");
            System.out.println("(2): 4x4");
            System.out.println("(3): Truck");
            System.out.println("(4): Van");
            System.out.println("(5): All");
            int input = keyboard.nextInt();
            input = input - 1;
            if (input == 0 || input == 1 || input == 2 || input == 3 || input == 4) {
                Type options = Type.values()[input];
                switch (options) {
                    case Car:
                        type ="Car";
                        running = false;
                        break;
                    case FourByFour:
                        type = "4x4";
                        running = false;
                        break;
                    case Truck:
                        type = "Truck";
                        running = false;
                        break;
                    case Van:
                        type = "Van";
                        running = false;
                        break;
                    case All:
                        type = "All";
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid Input.");
                }
            } else {
                System.out.println("Invalid Input.");
            }

        }
        return type;
    }
}
