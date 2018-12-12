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
        System.out.println("(4):Edit Passenger");
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

    /**
     * Displays Main Menu returns false if Quit is selected otherwise keeps running true and the programming going.
     * @return
     */
    public static boolean mainMenuSelector()
    {

        int input = MainmenuChecker();
        input = input - 1;
        Mainmenu options = Mainmenu.values()[input];
        switch(options)
        {
            case PASSENGERS:
                passengerMenu();
                break;
            case BOOKINGS:
                bookingsMenu();
                break;
            case VEHICLES:
                vehicleMenu();
                break;
            case QUIT:
                return false;
            default:
                System.out.println("Invalid Input.");

        }
        return true;
    }

    /**
     * Displays the passenger menu and allows you to select it
     */
    public static void passengerMenuSelector()
    {

        int input = menuChecker();
        input = input - 1;
        GeneralMenu options = GeneralMenu.values()[input];
        switch(options)
        {
            case VIEW:
                DisplaySettings.displayPassengers(Main.PassengerList);
                break;
            case ADD:
                Main.PassengerList.add(addClass.addPassenger(Main.PassengerList));
                break;
            case REMOVE:
                int ID = Remove.removePassenger();
                Main.PassengerList.remove(ID);
                break;
            case EDIT:
                Edit.EditPassenger();
                break;
            case QUIT:

                break;
            default:
                System.out.println("Invalid Input.");

        }
    }

    /**
     * Displays Vehicle menu and changes to whatever screen people want
     */
    public static void vehicleMenuSelector()
    {
        int input = vehicleChecker();
        input = input - 1;
        vehicleMenu options = vehicleMenu.values()[input];
        switch(options)
        {
            case VIEW:
                String type =  Main.VehicleSelect();
                DisplaySettings.displayVehiclesByType(Main.VehicleList,type);
                break;
            case ADD:
                Main.VehicleList.add(addClass.addVehicle(Main.VehicleList));
                break;
            case QUIT:

                break;
            default:
                System.out.println("Invalid Input.");
        }
    }

    /**
     * Displays Booking menu and changes to whatever screen people want
     */
    public static void bookingMenuSelector()
    {

        int input = menuChecker();
        input = input - 1;
        GeneralMenu options = GeneralMenu.values()[input];
        switch(options)
        {
            case VIEW:
                DisplaySettings.displayBookings(Main.Bookings);
                break;
            case ADD:
                String psg = Main.selectCurrentPassenger();
                Main.Bookings.add(addClass.addBooking(Main.VehicleList,psg));
                break;
            case REMOVE:
                int ID = Main.BookingSelector();
                System.out.println("Booking Successfully Deleted");
                Main.Bookings.remove(ID);
                break;
            case EDIT:
                Edit.EditBooking();
                break;
            case QUIT:
                break;
            default:
                System.out.println("Invalid Input.");

        }
    }

    /**
     * Only allows selected int to be returned to the menuselector
     */
    public static int menuChecker()
    {
        boolean running = true;
        Scanner sc = new Scanner(System.in);
        int input = 0;
        while(running)
        {
            input = integerChecker();
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
    /**
     * Only allows selected int to be returned to the menuselector
     */
    public static int MainmenuChecker()
    {
        boolean running = true;
        Scanner sc = new Scanner(System.in);
        int input = 0;
        while(running)
        {
            input = integerChecker();
            if(input == 1 || input == 2 || input == 3 || input ==4)
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
    /**
     * Only allows selected int to be returned to the menuselector
     */
    public static int vehicleChecker()
    {
        boolean running = true;
        Scanner sc = new Scanner(System.in);
        int input = 0;
        while(running)
        {
            input = integerChecker();
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

    /**
     * This returns an int so long as user input is an int else it keeps asking for an int
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
