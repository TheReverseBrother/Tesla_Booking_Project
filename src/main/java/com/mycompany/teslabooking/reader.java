/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teslabooking;

import java.io.*;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
/**
 *
 * @author Tomas
 */
public class reader 
{
    public static void main(String[] args) throws FileNotFoundException
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
