package com.mycompany.teslabooking;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class addClass
{
    static DecimalFormat df = new DecimalFormat("#.00");

    /**
     * This takes in the passengerlist and returns brand new passenger
     * making sure that an email entered has not been in use.
     * @param passengerList
     * @return
     */
    public static Passenger addPassenger(ArrayList<Passenger> passengerList)
    {
        boolean check = true;
        boolean running = true;

        String name = "",email = "",phone = "";
        double longitude = 0;
        double lattitude = 0;
        Scanner sc = new Scanner(System.in);
        while(running)
        {
            System.out.println("Please Enter Your Name");
            name = sc.nextLine();
            System.out.println("Please Enter Your Email");
            email = sc.nextLine();
            while (check) {
                int checker = 0;
                System.out.println("Please Enter Your PhoneNumber");
                phone = sc.nextLine();
                for (int i = 0; i < phone.length(); i++) {
                    phone.trim();
                    if (Character.isLetter(phone.charAt(i))) {
                        checker++;
                    }
                }
                if (checker == 0) {
                    check = false;
                }
            }
            System.out.println("Please Enter Your Home Lattitude");
            lattitude = doubleChecker();
            System.out.println("Please Enter Your Home Longitude");
            longitude = doubleChecker();
            running = passengerChecker(passengerList, email);
        }
        Passenger ToBeAdded = new Passenger(name,email,phone,new Location(longitude,lattitude));
        System.out.println("Passenger successfully added");
        return ToBeAdded;
    }

    /**
     * Checks for a duplicate email
     * @param PassengerList
     * @param email
     * @return
     */
    public static boolean passengerChecker(ArrayList<Passenger> PassengerList, String email)
    {
        for(int i =0;i<PassengerList.size();i++)
        {
            if(PassengerList.get(i).getEmail() == email)
            {
                System.out.println("Email In Use Please Enter Different Details");
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a vehicle booking to be added to the list
     * @param Vehicles
     * @param passengerID
     * @return
     */
    public static vehicleBooking addBooking(ArrayList<Vehicle> Vehicles, String passengerID)
    {
        Scanner sc = new Scanner(System.in);
        String input;
        double cost =0,startlattitude =0,startlongitude =0,endlattitude =0,endlongitude =0;
        String vehicleReg = "";
        Date date1 = null;
        boolean running = true;
        vehicleBooking newBooking = null;
        while (running)
        {
            System.out.println("Please Choose VehicleType");
            vehicleReg = VehicleType(Vehicles);
            System.out.println("Please Enter Booking Date DD/MM/YYYY");
            date1 = dateChecker();
            System.out.println("Please Enter Start Location Longitude");
            startlongitude = doubleChecker();
            System.out.println("Please Enter Start Location Lattitude");
            startlattitude = doubleChecker();
            System.out.println("Please Enter End Location Longitude");
            endlongitude = doubleChecker();
            System.out.println("Please Enter End Location Lattitude");
            endlattitude = doubleChecker();
            cost = bookingCost(Vehicles,vehicleReg,startlattitude,startlongitude,endlattitude,endlongitude);
            String cost1 = df.format(cost);
            System.out.println("Cost of This Journey is: " +cost1+".");


            newBooking = new vehicleBooking(passengerID,date1,new Location(startlongitude,startlattitude),new Location(endlongitude,endlattitude),vehicleReg,cost);
            if(Main.Bookings.contains(newBooking))
            {
                running = true;
                System.out.println("Booking Already Made Please Try Again");
            }
            else
            {
                running = false;
            }

        }
        String email = "";
//        for(int i = 0 ;i<Main.PassengerList.size();i++)
//        {
//            if(passengerID.equals(Main.PassengerList.get(i).getPassengerID()))
//            {
//                email = Main.PassengerList.get(i).getEmail();
//            }
//        }
//        Email.EmailPrep(email);
        System.out.println("");
        System.out.println("Booking successfully added");
        System.out.println("");
        return newBooking;
    }


    /**
     * Gets the booking cost of trip
     * @param Vehicles
     * @param vehicleReg
     * @param startLat
     * @param startLong
     * @param endlat
     * @param endLong
     * @return
     */
    public static double bookingCost( ArrayList<Vehicle> Vehicles,String vehicleReg, double startLat, double startLong, double endlat, double endLong)
    {
        double lattitude= 0,longitude = 0,firstValue,secondValue,thirdvalue,finalvalue,over,up,cost = 0,holder;

        for(int i = 0;i<Vehicles.size();i++)
        {
            if(Vehicles.get(i).getRegistration() == vehicleReg)
            {
                lattitude = Vehicles.get(i).getLatitude();
                longitude = Vehicles.get(i).getLongitude();
                cost = Vehicles.get(i).getCostPerMile();
            }
        }
        over = lattitude - startLat;
        up = longitude - startLong;
        holder = (over * over) + (up*up);
        firstValue = Math.sqrt(holder);
        over = startLat - endlat;
        up = startLong - endLong;
        holder = (over * over) + (up*up);
        secondValue = Math.sqrt(holder);
        over = endlat - lattitude;
        up = endLong - longitude;
        holder = (over * over) + (up*up);
        thirdvalue = Math.sqrt(holder);
        finalvalue = (firstValue * cost) +(secondValue * cost) + (thirdvalue * cost);

        return finalvalue;
    }


    /**
     * Allows you to select type of vehicle wanted
     */
    enum Type {Car,FourByFour,Truck,Van}
    public static String VehicleType(ArrayList<Vehicle> vehicleList)
    {
        boolean running = true;
        String reg = "";
        Scanner keyboard = new Scanner(System.in);
        while (running)
        {
            System.out.println("(1): Car");
            System.out.println("(2): 4x4");
            System.out.println("(3): Truck");
            System.out.println("(4): Van");
            int input = keyboard.nextInt();
            input = input - 1;
            if (input == 0 || input == 1 || input == 2 || input == 3) {
                Type options = Type.values()[input];
                switch (options) {
                    case Car:
                        for (int i = 0; i < vehicleList.size(); i++)
                        {
                            if (vehicleList.get(i).getType() == "Car")
                            {
                                if(vehicleList.get(i).isInDepot() == true)
                                {
                                    reg = vehicleList.get(i).getRegistration();
                                    vehicleList.get(i).setInDepot(false);
                                    running = false;
                                    i = 1000;
                                }
                            }
                        }
                        break;
                    case FourByFour:
                        for (int i = 0; i < vehicleList.size(); i++) {
                            if (vehicleList.get(i).getType() == "4x4" && vehicleList.get(i).isInDepot() == true) {
                                reg = vehicleList.get(i).getRegistration();
                                vehicleList.get(i).setInDepot(false);
                                running = false;
                            }
                        }
                        break;
                    case Truck:
                        for (int i = 0; i < vehicleList.size(); i++) {
                            if (vehicleList.get(i).getType() == "Truck" && vehicleList.get(i).isInDepot() == true) {
                                reg = vehicleList.get(i).getRegistration();
                                vehicleList.get(i).setInDepot(false);
                                running = false;
                            }
                        }
                        break;
                    case Van:
                        for (int i = 0; i < vehicleList.size(); i++) {
                            if (vehicleList.get(i).getType() == "Van" && vehicleList.get(i).isInDepot() == true) {
                                reg = vehicleList.get(i).getRegistration();
                                vehicleList.get(i).setInDepot(false);
                                running = false;
                            }
                        }
                        break;
                    default:
                        System.out.println("Invalid Input.");
                }
            } else {
                System.out.println("Invalid Input.");
            }

        }
        return reg;
    }
// the most roundabout double cheker id ever made
//    public static Double doubleCheckery()
//        {
//            Scanner sc = new Scanner(System.in);
//            boolean check = true;
//            double number = 0;
//            while (check) {
//                String num = sc.next()  + ".";
//                int checker = 0;
//                if(num.contains("."))
//                {
//                    System.out.println("In first if statement");
//                    String[] splitter = num.split(".");
//                    for (int i = 0; i < splitter.length; i++) {
//                        System.out.println("In first forloop");
//                        for(int j = 0; j<splitter[i].length(); j++)
//                        {
//                            System.out.println(splitter[i].charAt(j));
//                            if(Character.isLetter(splitter[i].charAt(j)))
//                            {
//                                checker++;
//                            }
//                        }
//                    }
//                    if (checker == 0) {
//                        number = Double.parseDouble(num.trim());
//                        check = false;
//                    }
//                    else {
//                        System.out.println("Please Enter A Valid Number");
//                    }
//                }
//                else
//                {
//                    System.out.println("Please Enter in format %%.%%");
//                }
//
//
//            }
//            return number;
//  }

    /**
     * Checks for double input
     * @return
     */
    public static double doubleChecker()
    {
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        double number = 0;
        while (check)
        {
            try
            {
                number = Double.parseDouble(sc.next());
                check = false;
            }
            catch(NumberFormatException ignore)
            {
                System.out.println("Please Enter Valid Number");
            }

        }
        return number;
    }

    /**
     * Checks for integer input
     * @return
     */
    public static int integerChecker()
    {
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        int number = 0;
        while (check)
        {
            try
            {
                number = Integer.parseInt(sc.next());
                check = false;
            }
            catch(NumberFormatException ignore)
            {
                System.out.println("Please Enter Valid Number");
            }

        }
        return number;
    }

    /**
     * Checks for date input
     * @return
     */
    public static Date dateChecker()
    {
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        Date gg = null;
        String sDate1="31/12/1998";
        while (check)
        {
            try
            {
                Date number = new SimpleDateFormat("dd/MM/yyyy").parse(sc.next());
                check = false;
                return number;
            }
            catch(NumberFormatException ignore)
            {
                System.out.println("Please Enter Valid Date DD/MM/YYYY");
            }
            catch(ParseException e)
            {
                System.out.println("Please Enter Valid Date DD/MM/YYYY");
            }

        }
        return gg;
    }

    /**
     * Allows you to add a vehicle and input new
     * @param VehicleList
     * @return
     */
    public static Vehicle addVehicle(ArrayList<Vehicle> VehicleList)
    {
        Scanner sc = new Scanner(System.in);
        String type;
        System.out.println("Please Select Type");
        type = VehicelSelect();
        System.out.println("Please Enter Make");
        String make = sc.next();
        System.out.println("Please Enter Model");
        String model = sc.next();
        System.out.println("Please Enter MilesPerKWh rounded Up");
        int milesperkwh = integerChecker();
        System.out.println("Please Enter Registration Number");
        String registration = sc.next();
        System.out.println("Please Enter Amount of Seats");
        int seats =integerChecker();
        System.out.println("Please Enter Mileage");
        int mileage = integerChecker();
        System.out.println("Please Enter Depot latitude");
        double latitude = doubleChecker();
        System.out.println("Please Enter Depot Longitude");
        double longitude = doubleChecker();
        if(type == "Car")
        {
            Car newCar = new Car(make,model,milesperkwh,seats,registration,mileage,new Location(longitude,latitude),true);
            return newCar;
        }
        if(type == "Van")
        {
            System.out.println("Please Enter The Loadspace(m2)");
            double loadspace = doubleChecker();
            Van newVan = new Van(make,model,milesperkwh,seats,registration,mileage,new Location(longitude,latitude),true,loadspace);
            return newVan;
        }
        if(type == "Truck")
        {
            System.out.println("Please Enter The Loadspace(m2)");
            double loadspace = doubleChecker();
            Truck newVan = new Truck(make,model,milesperkwh,seats,registration,mileage,new Location(longitude,latitude),true,loadspace);
            return newVan;
        }
        if(type == "4x4")
        {
           FourbyFour new4x4 = new FourbyFour(make,model,milesperkwh,seats,registration,mileage,new Location(longitude,latitude),true);
           return new4x4;
        }

        Car wCar = new Car(make,model,milesperkwh,seats,registration,mileage,new Location(longitude,latitude),true);
        System.out.println("");
        System.out.println("Vehicle successfully added");
        System.out.println("");
        return  wCar;
    }

    /**
     * Selects a vehicle for booking to use returns vehicle reg.
     * @return
     */
    public static String VehicelSelect()
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
            int input = keyboard.nextInt();
            input = input - 1;
            if (input == 0 || input == 1 || input == 2 || input == 3) {
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
                    default:
                        System.out.println("Invalid Input.");
                }
            } else {
                System.out.println("Invalid Input.");
            }

        }
        return type;
    }

    /**
     * Used to check that a reg has not been entered.
     * @param Vehicles
     * @return
     */
    public static String regChecker(ArrayList<Vehicle> Vehicles)
    {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        String reg = "";
        while(running)
        {
            reg = sc.next();
            for (int i = 0; i<Vehicles.size();i++)
            {
                if (Vehicles.get(i).getRegistration() != reg)
                {
                    running = false;
                }
                else
                {
                    System.out.println("That Registration is already Registered Please Enter Another One");
                }
            }
        }
        return reg;
    }
}
