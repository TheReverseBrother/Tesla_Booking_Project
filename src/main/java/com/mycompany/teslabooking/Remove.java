package com.mycompany.teslabooking;

public class Remove
{
//    public static int removeBooking()
//    {
//        int bookingID = Main.BookingSelector();
//        int ID = 0;
//        for(int i = 0; i < Main.PassengerList.size();i++)
//        {
//            if (Main.Bookings.get(i).getBookingnumber() == bookingID)
//            {
//                ID = i;
//            }
//        }
//        System.out.println("Booking Succesfully Deleted");
//        return ID;
//    }
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

}
