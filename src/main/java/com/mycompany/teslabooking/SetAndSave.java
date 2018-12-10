package com.mycompany.teslabooking;


import java.io.*;
import java.util.Date;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.DecimalFormat;

public class SetAndSave
{

    public static void setCosts()
    {
        try{
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
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error Loading Costs");
        }

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

    /**
     * Loads the array with all previously entered info
     * @return
     */
    public static ArrayList<Vehicle> vehiclesList()
    {
        ArrayList<Vehicle> VehicleList = new ArrayList<>();
        try {
            File inputFile = new File("vehicles.txt");
            Scanner input = new Scanner(inputFile);
            while (input.hasNext())
            {
                String line = input.nextLine();
                String[] Info = line.split(",");
                String type = Info[0];
                String make = Info[1].trim();
                String model = Info[2].trim();
                int milesPerKH = Integer.parseInt(Info[3].trim());
                int seats = Integer.parseInt(Info[4].trim());
                String registration = Info[5].trim();
                double mileage = Double.parseDouble(Info[6].trim());
                double latitude = Double.parseDouble(Info[7].trim());
                double longitude = Double.parseDouble(Info[8].trim());
                boolean inDepot = Boolean.parseBoolean(Info[9].trim());//this is the problem need to check and see if writing to file works
                if (type.equals("Car"))
                {
                    VehicleList.add(new Car(make, model, milesPerKH, seats,
                            registration, mileage, new Location(latitude, longitude), inDepot));
                }
                else if (type.equals("Van"))
                {
                    double loadspace = Double.parseDouble(Info[10].trim());
                    VehicleList.add(new Van(make, model, milesPerKH,
                            seats, registration, mileage, new Location(latitude, longitude), inDepot, loadspace));
                }
                else if (type.equals("Truck"))
                {
                    double loadspace = Double.parseDouble(Info[10].trim());
                    VehicleList.add(new Truck(make, model, milesPerKH,
                            seats, registration, mileage, new Location(latitude, longitude), inDepot, loadspace));
                }
                else if (type.equals("4x4"))
                {
                    VehicleList.add(new FourbyFour(make, model, milesPerKH,
                            seats, registration, mileage, new Location(latitude, longitude), inDepot));
                }
                else {
                    break;
                }
            }
            input.close();

        }
        catch(Exception e)
        {
            System.out.println("Error Loading Vehicles");
        }
        return VehicleList;
    }

    public static void saveVehicles(ArrayList VehicleList)
    {
        ArrayList<Vehicle> write = VehicleList;
        String type,make,model,milesperKH,seats,registration,mileage,longitude,latitude,inDepot,loadspace;

        try(FileWriter costFile = new FileWriter("vehicles.txt"))
        {
            for(int i = 0; i < write.size(); i++)
            {
                type = ""+ write.get(i).getType();
                make = "" +write.get(i).getMake();
                model = "" +write.get(i).getModel();
                milesperKH = "" +write.get(i).getMilesPerKH();
                seats = "" +write.get(i).getSeats();
                registration = "" +write.get(i).getRegistration();
                mileage = "" +write.get(i).getMileage();
                longitude = "" +write.get(i).getLongitude();
                latitude = "" +write.get(i).getLatitude();
                inDepot = "" +write.get(i).isInDepot();
                if(write.get(i).getType() == "Van" || write.get(i).getType() == "Truck")//type == "Van" || type == "Truck"
                {
                    loadspace = "" +write.get(i).getLoadSpace();
                    costFile.write(""+type +"," +make+","+model+","+milesperKH+","+seats+","+registration
                            +","+mileage+","+longitude+","+latitude+","+inDepot+","+loadspace+"\n");
                }
                else {
                    costFile.write("" + type + "," + make + "," + model + "," + milesperKH + "," + seats + "," + registration
                            + "," + mileage + "," + longitude + "," + latitude + "," + inDepot+"\n");
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Error Saving vehicles List, the info is inputed " +
                    "automatically if you see this Tomas you fucked it up beyond belief");
        }
    }

    public static ArrayList<Passenger> PassengerList()
    {
        ArrayList<Passenger> PassengerList = new ArrayList<>();
        try {
            File inputFile = new File("passengers.txt");
            Scanner input = new Scanner(inputFile);
            while (input.hasNext())
            {
                String line = input.nextLine();
                String[] Info = line.split(",");
                String name = Info[0].trim();
                String email = Info[1].trim();
                String phone = Info[2].trim();
                double lattitude = Double.parseDouble(Info[3].trim());
                double longitude  = Double.parseDouble(Info[4].trim());
                PassengerList.add(new Passenger(name,email,phone,new Location(lattitude,longitude)));
            }
            input.close();
        }
        catch(Exception e)
        {
            System.out.println("Error Loading Passenger List");
        }
        return PassengerList;
    }

    public static void savePassengers(ArrayList PassengerList)
    {
        ArrayList<Passenger> write = PassengerList;
        String name,email,phone,longitude,latitude;

        try(FileWriter passengerFile = new FileWriter("passengers.txt"))
        {
            for(int i = 0; i < write.size(); i++)
            {
                name = ""+ write.get(i).getName();
                email = "" +write.get(i).getEmail();
                phone = "" +write.get(i).getPhoneNumber();
                longitude = "" +write.get(i).getHomeLongitude();;
                latitude = "" +write.get(i).getHomeLatitude();;
                    passengerFile.write(name+","+email+","+phone+","+longitude+","+latitude+"\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Failed To save Passengers");
        }
    }

    public static ArrayList<vehicleBooking> BookingList()
    {
        ArrayList<vehicleBooking> BookingList = new ArrayList<>();
        try {
            File inputFile = new File("bookings.txt");
            Scanner input = new Scanner(inputFile);
            while (input.hasNext())
            {
                String line = input.nextLine();
                String[] Info = line.split(",");
                String psgID = Info[0].trim();
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(Info[1].trim());;
                double slongitude  = Double.parseDouble(Info[2].trim());
                double slattitude = Double.parseDouble(Info[3].trim());
                double elongitude  = Double.parseDouble(Info[4].trim());
                double elattitude = Double.parseDouble(Info[5].trim());
                String registration = Info[6].trim();
                double cost = Double.parseDouble(Info[7].trim());
                BookingList.add(new vehicleBooking(psgID,date,new Location(slongitude,slattitude),new Location(elongitude,elattitude),registration, cost));
            }
            input.close();
        }
        catch(Exception e)
        {
            System.out.println("Error Loading List");
        }
        return BookingList;
    }

    public static void saveBookings(ArrayList BookingList)
    {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        DecimalFormat NumF = new DecimalFormat("#.00");
        ArrayList<vehicleBooking> write = BookingList;
        String PassengerID,date,slongitude,slattitude,elongitude,elattitude, registration, cost;

        try(FileWriter bookFile = new FileWriter("bookings.txt"))
        {
            for(int i = 0; i < write.size(); i++)
            {
                PassengerID = ""+ write.get(i).getPassengerID();
                date = df.format(write.get(i).getBookingDT());
                slongitude = "" +write.get(i).getStartLongitude();
                slattitude = "" +write.get(i).getStartlattitude();
                elongitude = "" +write.get(i).getEndLongitude();
                elattitude = "" +write.get(i).getEndlattitude();
                registration = "" +write.get(i).getVehicleBooked();
                cost = "" + NumF.format(write.get(i).getBookingCost());
                bookFile.write(PassengerID+","+date+","+slongitude+","+slattitude+","+elongitude+","+elattitude+","+registration+","+cost+"\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
