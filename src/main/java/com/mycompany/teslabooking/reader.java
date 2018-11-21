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

        File inputFile = new File("carcosts");
        Scanner input = new Scanner(inputFile);
        String line = "";
        while(input.hasNext())
        {
            
            Scanner fi = new Scanner(line);
            fi.useDelimiter("[^\\p{Alnum},\\.]"); 
            while (true) {
                if (fi.hasNext())
                    System.out.println("WORD: " + fi.next());
                else if (fi.hasNextDouble())
                    System.out.println("Double: " + fi.nextDouble());
                else
                    break;
            }      
        }
        
    }
}
