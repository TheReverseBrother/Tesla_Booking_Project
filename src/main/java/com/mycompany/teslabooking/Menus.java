package com.mycompany.teslabooking;

import java.util.Scanner;

//Main class was getting very cluttered with large amount of menus so i put them all here
public class Menus
{

    public static boolean mainMenu()
    {
        System.out.println("Please Choose An Option:");
        System.out.println("(1):Passengers");
        System.out.println("(2):Bookings");
        System.out.println("(3):Vehicles");
        System.out.println("(4): Quit");
        return mainMenuSelector();

    }

    public static void passengerMenu()
    {
        System.out.println("Please Choose An Option:");
        System.out.println("(1):View All Passengers");
        System.out.println("(2):Add Passengers");
        System.out.println("(3):Remove Passenger");
        System.out.println("(4):Edit Booking");
        System.out.println("(5): Quit");
        passengerMenuSelector();
    }

    public static void vehicleMenu()
    {
        System.out.println("Please Choose An Option:");
        System.out.println("(1):View All Vehicles");
        System.out.println("(2):Add vehicle");
        System.out.println("(3):Quit");
        vehicleMenuSelector();
    }
    public static void bookingsMenu()
    {
        System.out.println("Please Choose An Option:");
        System.out.println("(1):View All Bookings");
        System.out.println("(2):Add Booking");
        System.out.println("(3):Remove Booking");
        System.out.println("(4):Edit Booking");
        System.out.println("(5):Quit");
        bookingMenuSelector();
    }



    enum Mainmenu {Passengers,Bookings,Vehicles,Quit;}
    public static boolean mainMenuSelector()
    {

        int input = menuChecker();
        input = input - 1;
        Mainmenu options = Mainmenu.values()[input];
        switch(options)
        {
            case Passengers:
                passengerMenu();
                break;
            case Bookings:
                bookingsMenu();
                break;
            case Vehicles:
                vehicleMenu();
                break;
            case Quit:
                return false;
            default:
                System.out.println("Invalid Input.");

        }
        return true;
    }

    enum vehicleMenu{View,Add,Quit;}
    enum GeneralMenu{View,Add,Remove,Edit,Quit;}

    public static void passengerMenuSelector()
    {

        int input = menuChecker();
        input = input - 1;
        GeneralMenu options = GeneralMenu.values()[input];
        switch(options)
        {
            case View:
                DisplaySettings.displayPassengers(Main.PassengerList);
                break;
            case Add:
                Main.PassengerList.add(addClass.addPassenger(Main.PassengerList));
                break;
            case Remove:
                int ID = Remove.removePassenger();
                Main.PassengerList.remove(ID);
                break;
            case Edit:
                Edit.EditPassenger();
                break;
            case Quit:

                break;
            default:
                System.out.println("Invalid Input.");

        }
    }


    public static void vehicleMenuSelector()
    {
        int input = vehicleChecker();
        input = input - 1;
        vehicleMenu options = vehicleMenu.values()[input];
        switch(options)
        {
            case View:
                String type =  Main.VehicleSelect();
                DisplaySettings.displayVehiclesByType(Main.VehicleList,type);
                break;
            case Add:
                Main.VehicleList.add(addClass.addVehicle(Main.VehicleList));
                break;
            case Quit:

                break;
            default:
                System.out.println("Invalid Input.");
        }
    }


    public static void bookingMenuSelector()
    {

        int input = menuChecker();
        input = input - 1;
        GeneralMenu options = GeneralMenu.values()[input];
        switch(options)
        {
            case View:
                DisplaySettings.displayBookings(Main.Bookings);
                break;
            case Add:
                String psg = Main.selectCurrentPassenger();
                Main.Bookings.add(addClass.addBooking(Main.VehicleList,psg));
                break;
            case Remove:
//                int ID = Remove.removeBooking();
                int ID = Main.BookingSelector();
                System.out.println("Booking Successfully Deleted");
                Main.Bookings.remove(ID);
                break;
            case Edit:
                Edit.EditBooking();
                break;
            case Quit:
                break;
            default:
                System.out.println("Invalid Input.");

        }
    }
    public static int menuChecker()
    {
        boolean running = true;
        Scanner sc = new Scanner(System.in);
        int input = 0;
        while(running)
        {
            input = sc.nextInt();
            if(input == 1 || input == 2 || input == 3 || input ==4|| input == 5)
            {
                running = false;
            }
            else
                {
                    System.out.println("Please Enter Valid Choice");
                }
        }
        return input;
    }
    public static int vehicleChecker()
    {
        boolean running = true;
        Scanner sc = new Scanner(System.in);
        int input = 0;
        while(running)
        {
            input = sc.nextInt();
            if(input == 1 || input == 2 || input == 3)
            {
                running = false;
            }
            else
            {
                System.out.println("Please Enter Valid Choice");
            }
        }
        return input;
    }
}
