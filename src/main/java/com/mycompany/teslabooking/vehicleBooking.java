package com.mycompany.teslabooking;


public class vehicleBooking
{
    private String passengerID;
    private static int totalBookings;
    private int bookingnumber;
    private String bookingDT;
    private Location startLocation;
    private Location endLocation;
    private String vehicleBooked;
    private double bookingCost;

    public vehicleBooking(String passengerID, String bookingDT, Location startLocation, Location endLocation, String vehicleBooked, double bookingCost)
    {
        totalBookings++;
        this.passengerID = passengerID;
        this.bookingnumber = totalBookings;
        this.bookingDT = bookingDT;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.vehicleBooked = vehicleBooked;
        this.bookingCost = bookingCost;
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

    public double getBookingCost()
    {
        return bookingCost;
    }

    public double getStartlattitude()
    {
        return startLocation.getLatitude();
    }
    public double getStartLongitude()
    {
        return startLocation.getLongitude();
    }
    public double getEndlattitude()
    {
        return endLocation.getLatitude();
    }
    public double getEndLongitude()
    {
        return endLocation.getLongitude();
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public String getVehicleBooked()
    {
        return vehicleBooked;
    }

    @Override
    public String toString() {
        return "vehicleBooking{" +"passengerID=" + passengerID + ", bookingnumber=" + bookingnumber + ", bookingDT="
                + bookingDT + ", startLocation=" + startLocation + ", endLocation=" + endLocation + '}';
    }
}
