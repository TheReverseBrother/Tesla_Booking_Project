package com.mycompany.teslabooking;

import java.util.ArrayList;

public class DisplaySettings
{
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
        System.out.println("_____________________________________________________________________________________________________________________________________");
        System.out.println("|_________________________________________________________" +
                "____________________________________________________________________________|");
        System.out.format(format,"PassengerID","Name","Email","PhoneNo:","Home Location");
        for(int i = 0; i <PassengerList.size();i++)
        {
            passengerID = PassengerList.get(i).getPassengerID();
            name = "" +PassengerList.get(i).getName();
            email = "" +PassengerList.get(i).getEmail();
            phoneNo = ""+ PassengerList.get(i).getPhoneNumber();
            home = "" + PassengerList.get(i).getHome();
            System.out.format(format, passengerID, name, email,phoneNo,home);
        }
        System.out.println("|_____________________________________________________________________________________________________________________________________|");
    }

    public static void displayVehiclesByType(ArrayList<Vehicle> Vehicles,String type)
    {
        String model,make,milesPer,seats,reg,costPer,mileage,depot,isDepot,Loadspace;

        String format = "|%1$-10s|%2$-15s|%3$-15s|%4$-10s|%5$-15s|%6$-15s|%7$-15s|%8$-20s|%9$-15s|%10$-10s|\n";
        System.out.println("_________________________________________________________________________________________________________________________________________________________________");
        System.out.println("|_______________________________________________________________________________________________________________________________________________________________|");
        System.out.format(format,"Make","Model","Miles PerKWh","Seats","Registration","CostPerMile","Mileage","Depot","Loadspace","In Depot?");
        for(int i = 0; i <Vehicles.size();i++)
        {

            model = Vehicles.get(i).getModel();
            make = Vehicles.get(i).getMake();
            milesPer ="" + Vehicles.get(i).getMilesPerKH();
            seats ="" + Vehicles.get(i).getSeats();
            reg = Vehicles.get(i).getRegistration();
            costPer = ""+ Vehicles.get(i).getCostPerMile();
            mileage = ""+Vehicles.get(i).getMileage();
            depot = ""+ Vehicles.get(i).getLocation();
            isDepot = "" + Vehicles.get(i).isInDepot();
            Loadspace = "" + Vehicles.get(i).getLoadSpace();
            if(Vehicles.get(i).getType() == type || type == "All")
            {
                System.out.format(format,make,model,milesPer,seats,reg,costPer,mileage,depot,Loadspace,isDepot);
            }
        }
        System.out.println("|________________________________________________________________________" +
                "_______________________________________________________________________________________|");

    }
}
