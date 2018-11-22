package com.mycompany.teslabooking;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

    public static void setVehicles()
    {
        
    }
}
