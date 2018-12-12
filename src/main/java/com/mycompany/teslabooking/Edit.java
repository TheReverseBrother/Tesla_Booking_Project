package com.mycompany.teslabooking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Edit
{
    /**
     * Calls a passenger selector and allows you to set new values for passenger details except for passenger ID and email as those are kept
     */
    public static void EditPassenger()
    {
        String PassengerID = Main.selectCurrentPassenger();
        Scanner sc = new Scanner(System.in);
        String name = "",email = "",phone = "";
        boolean check = true;
        boolean running = true;
        double longitude = 0;
        double lattitude = 0;
        while(running)
        {
            System.out.println("Please Enter Name");
            name = sc.nextLine();
            while (check)
            {
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
            System.out.println("Please Enter Home Latitude");
            lattitude= doubleChecker();
            System.out.println("Please Enter Home Longitude");
            longitude= doubleChecker();

            for(int i = 0; i <Main.PassengerList.size();i++)
            {
                if(Main.PassengerList.get(i).getPassengerID() == PassengerID)
                {
                    Main.PassengerList.get(i).setName(name);
                    Main.PassengerList.get(i).setPhoneNumber(phone);
                    Main.PassengerList.get(i).setHome(new Location(longitude,lattitude));
                }
            }
            System.out.println("");
            System.out.println("Successfully Update");
            System.out.println("");
            running = false;
        }


    }

    /**
     * Allows the editing of a selected booking chosen from the booking selector class in main.
     */

    public static void EditBooking()
    {
        int bookingid = Main.BookingSelector();
        String vehicleReg = Main.Bookings.get(bookingid).getVehicleBooked();
        double cost =0,startlattitude =0,startlongitude =0,endlattitude =0,endlongitude =0;
        System.out.println("Please Enter Booking Date");
        Date date = dateChecker();
        System.out.println("Please Enter Start Latitude");
        startlattitude = doubleChecker();
        System.out.println("Please Enter Start Longitude");
        startlongitude = doubleChecker();
        System.out.println("Please Enter End Latitude");
        endlattitude = doubleChecker();
        System.out.println("Please Enter End Longitude");
        endlongitude = doubleChecker();
        cost = addClass.bookingCost(Main.VehicleList,vehicleReg,startlattitude,startlongitude,endlattitude,endlongitude);
        System.out.println("The Revised Booking Cost is " +cost);
        Main.Bookings.get(bookingid).setBookingDT(date);
        Main.Bookings.get(bookingid).setStartLocation(new Location(startlongitude,startlattitude));
        Main.Bookings.get(bookingid).setEndLocation(new Location(endlongitude,endlattitude));
        Main.Bookings.get(bookingid).setBookingCost(cost);
    }

    /**
     * This returns a date by continously parsing user input until a correct date is entered
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
                System.out.println("Please Enter Valid Date %%/%%/%%%%");
            }
            catch(ParseException e)
            {
                System.out.println("Please Enter Valid Date %%/%%/%%%%");
            }

        }
        return gg;
    }

    /**
     * This returns an int by continously parsing user input until a correct in is entered.
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
     * This returns an int by continously parsing user input until a correct in is entered.
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


}
