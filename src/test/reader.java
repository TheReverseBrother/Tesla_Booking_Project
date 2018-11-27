/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teslabooking;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.Boolean;
/**
 *
 * @author Tomas
 */
public class reader 
{
    public static void main(String[] args)
    {
        float ten = 0860708107;
        System.out.println(float);
//        boolean checking = true;
//        boolean checking2 = false;
//            try(FileWriter costFile = new FileWriter("login.txt"))
//            {
//                costFile.write(""+checking);
//                costFile.write(""+checking2);
//            }
//            catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//        vehiclesList();
    }


    public static void vehiclesList()
    {
        try {
            File inputFile = new File("login.txt");
            Scanner input = new Scanner(inputFile);
            input.useDelimiter(",");
            boolean YOYO;
            while (input.hasNext())
            {
                String data = input.nextLine();
                Scanner line = new Scanner(data);
                line.useDelimiter(",");
                YOYO =Boolean.parseBoolean(line.next());
                System.out.println("" + YOYO);
                String s1= line.next();
                System.out.println(s1);
                String s2 = line.next();
                System.out.println(s2);
                String s3 =
            }
            input.close();

        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error Loading List");
        }
    }
}
