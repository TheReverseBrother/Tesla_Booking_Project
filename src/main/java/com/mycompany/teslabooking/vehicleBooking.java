package com.mycompany.teslabooking;
import java.util.Date;

public class vehicleBooking implements IAverage, Comparable<vehicleBooking>
{
    private String passengerID;
    private static int totalBookings;
    private int bookingnumber;
    private Date bookingDT;
    private Location startLocation;
    private Location endLocation;
    private String vehicleBooked;
    private double bookingCost;

    public vehicleBooking(String passengerID, Date bookingDT, Location startLocation, Location endLocation, String vehicleBooked, double bookingCost)
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

    public vehicleBooking(String passengerID, int bookingnumber, Date bookingDT, Location startLocation, Location endLocation, String vehicleBooked, double bookingCost)
    {
        this.passengerID = passengerID;
        this.bookingnumber = bookingnumber;
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

    public Date getBookingDT() {
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

    public void setPassengerID(String passengerID)
    {
        this.passengerID = passengerID;
    }

    public static void setTotalBookings(int totalBookings)
    {
        vehicleBooking.totalBookings = totalBookings;
    }

    public void setBookingnumber(int bookingnumber)
    {
        this.bookingnumber = bookingnumber;
    }

    public void setBookingDT(Date bookingDT)
    {
        this.bookingDT = bookingDT;
    }

    public void setStartLocation(Location startLocation)
    {
        this.startLocation = startLocation;
    }

    public void setEndLocation(Location endLocation)
    {
        this.endLocation = endLocation;
    }

    public void setVehicleBooked(String vehicleBooked)
    {
        this.vehicleBooked = vehicleBooked;
    }

    public void setBookingCost(double bookingCost)
    {
        this.bookingCost = bookingCost;
    }

    @Override
    public int compareTo(vehicleBooking o)
    {
        return getBookingDT().compareTo(o.getBookingDT());
    }


    @Override
    public double getLength()
    {
        double over = this.getEndlattitude() - this.getStartlattitude();
        double up = this.getEndLongitude() - this.getStartLongitude();
        double holder = (over * over) + (up*up);
        double answer = Math.sqrt(holder);
        return answer;
    }

    @Override
    public String toString() {
        return "vehicleBooking{" +"passengerID=" + passengerID + ", bookingnumber=" + bookingnumber + ", bookingDT="
                + bookingDT + ", startLocation=" + startLocation + ", endLocation=" + endLocation + '}';
    }
}
