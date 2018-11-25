package com.mycompany.teslabooking;


import java.io.*;
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
                System.out.println(type +make +model +milesPerKH +seats +registration +mileage +latitude+longitude +inDepot);
                if (type.equals("Car"))
                {
                    System.out.println("Enter Car");
                    VehicleList.add(new Car(make, model, milesPerKH, seats,
                            registration, mileage, new Location(latitude, longitude), inDepot));
                }
                else if (type.equals("Van"))
                {
                    double loadspace = Double.parseDouble(Info[10].trim());
                    System.out.println("LOAD SOACE" +loadspace);
                    VehicleList.add(new Van(make, model, milesPerKH,
                            seats, registration, mileage, new Location(latitude, longitude), inDepot, loadspace));
                }
                else if (type.equals("Truck"))
                {
                    double loadspace = Double.parseDouble(Info[10].trim());
                    System.out.println("LOAD SOACE truck" +loadspace);
                    VehicleList.add(new Truck(make, model, milesPerKH,
                            seats, registration, mileage, new Location(latitude, longitude), inDepot, loadspace));
                }
                else if (type.equals("4x4"))
                {
                    System.out.println("Enter 4x4");
                    VehicleList.add(new FourbyFour(make, model, milesPerKH,
                            seats, registration, mileage, new Location(latitude, longitude), inDepot));
                }
                else {
                    System.out.println("Error");
                    break;
                }
            }
            input.close();

        }
        catch(Exception e)
        {
            System.out.println("Error Loading List");
        }
        return VehicleList;
    }

    public static void saveVehicles(ArrayList VehicleList)
    {
        ArrayList<Vehicle> write = VehicleList;
        String type,make,model,milesperKH,seats,registration,mileage,longitude,latitude,inDepot,loadspace;

        try(FileWriter costFile = new FileWriter("saveVehicles.txt"))
        {
            for(int i = 0; i < write.size(); i++)
            {
                type = ""+ write.get(i).getType();
                make = "" +write.get(i).getMake();
                model = "" +write.get(i).getModel();
                milesperKH = "" +write.get(i).getModel();;
                seats = "" +write.get(i).getModel();;
                registration = "" +write.get(i).getModel();;
                mileage = "" +write.get(i).getModel();;
                longitude = "" +write.get(i).getModel();;
                latitude = "" +write.get(i).getModel();;
                inDepot = "" +write.get(i).getModel();;
                if(type == "Van" || type == "Truck")
                {
                    loadspace = "" +write.get(i).getModel();
                    costFile.write(""+type +"," +make+","+model+","+milesperKH+","+seats+","+registration
                            +","+mileage+","+longitude+","+latitude+","+inDepot+","+loadspace+"\\n");
                }
                else {
                    costFile.write("" + type + "," + make + "," + model + "," + milesperKH + "," + seats + "," + registration
                            + "," + mileage + "," + longitude + "," + latitude + "," + inDepot+"\\n");
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
