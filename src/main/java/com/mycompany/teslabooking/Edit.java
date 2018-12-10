package com.mycompany.teslabooking;

public class Edit
{
    public static void EditPassenger()
    {
//        Main.selectCurrentPassenger();
        System.out.println("Please Enter Name");
        System.out.println("Please Enter Email");
        System.out.println("Please Enter Phone Number");
        System.out.println("Please Enter Home Latitude");
        System.out.println("Please Enter Home Longitude");
    }
    public static void EditBooking()
    {
        double cost= 0;
        System.out.println("Please Enter Booking Date");
        System.out.println("Please Enter Start Latitude");
        System.out.println("Please Enter Start Longitude");
        System.out.println("Please Enter End Latitude");
        System.out.println("Please Enter End Longitude");
        System.out.println("The Revised Booking Cost is " +cost);
    }
}
