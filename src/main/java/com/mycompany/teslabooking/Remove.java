package com.mycompany.teslabooking;

public class Remove
{
    public static void removeBooking()
    {

    }
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
        System.out.println("Passenger Succesfully Deleted");
        return ID;
    }
    public static void removeVehicle()
    {

    }

}
