package com.mycompany.teslabooking;

public class Remove
{
    /**
     * This takes the passenger id from remove passenger and removes the bookings made by said passenger
     * @param PassengerID
     */
    public static void removePassengerBooking(String PassengerID)
    {
        System.out.println(PassengerID);
        for(int i = 0; i < Main.Bookings.size();i++)
        {
            if (Main.Bookings.get(i).getPassengerID() == PassengerID)
            {
                Main.Bookings.remove(i);
            }
        }
        System.out.println("Booking Succesfully Deleted");
    }

    /**
     * This fetches the Passenger id from the method selectCurrentPAssenger Sorts through the
     * list finds the index and returns the index number to the remove passenger function in the menu
     * @return
     */
    public static int removePassenger()
    {
        String passengerId = Main.selectCurrentPassenger();
        int ID = 0;
        for(int i = 0; i < Main.PassengerList.size();i++)
        {
            if(Main.PassengerList.get(i).getPassengerID() == passengerId)
            {
                ID = i;
            }
        }
        removePassengerBooking(passengerId);
        System.out.println("");
        System.out.println("Passenger Succesfully Deleted");
        System.out.println("");

        return ID;
    }

}
