package com.mycompany.teslabooking;

import java.util.Calendar;

public class vehicleBooking
{
    Calendar cal = Calendar.getInstance();
    private String passengerID;
    private static int totalBookings;
    private int bookingnumber;
    private String bookingDT;
    private Location startLocation;
    private Location endLocation;

    public vehicleBooking(String passengerID, int bookingnumber, String bookingDT, Location startLocation, Location endLocation) {
        this.passengerID = passengerID;
        this.bookingnumber = bookingnumber;
        this.bookingDT = bookingDT;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        totalBookings++;
    }

    public Calendar getCal()
    {
        return cal;
    }

    public String getPassengerID() {
        return passengerID;
    }

    public static int getTotalBookings() {
        return totalBookings;
    }

    public int getBookingnumber() {
        return bookingnumber;
    }

    public String getBookingDT() {
        return bookingDT;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    @Override
    public String toString() {
        return "vehicleBooking{" + "cal=" + cal + ", passengerID=" + passengerID + ", bookingnumber=" + bookingnumber + ", bookingDT=" + bookingDT + ", startLocation=" + startLocation + ", endLocation=" + endLocation + '}';
    }
}
