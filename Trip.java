package com.taxibooking;

import java.util.List;

public class Trip {
    public static void printDetails(List<Taxi> taxis) {
        for (Taxi t : taxis) {
            List<String> trip = t.getTrip();
            System.out.println("Taxi - " + t.getId() + " Total Earnings - " + t.getTotalEarnings());
            System.out.println("TaxiID   DriverID   BookingID   CustomerID   From   To   PickupTime   DropTime   Amount");
            for (int i = 0; i < trip.size(); i++) {
                System.out.println(t.getId() +"          "+ t.getDriverId() + "          " +trip.get(i));
            }
            System.out.println("--------------------------------------------------------------------------------------");
        }
    }
}
