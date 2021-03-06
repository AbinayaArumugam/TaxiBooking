package com.taxibooking;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Runner {
    static   Scanner in=new Scanner(System.in);
    public static void main(String[] args){
        List<Taxi> taxis=CreateTaxis.createTaxi(4);
        int id=1;
        while (true){
            System.out.println("1.Booking");
            System.out.println("2.Display");
            System.out.println("3.Exit");
            System.out.println("Enter your choice");
            int choice=in.nextInt();
            switch (choice){
                case 1:
                   int customerId=id;
                    Booking booking=new Booking();
                    System.out.println("Enter Pickup point");
                    char pickupPoint=in.next().charAt(0);
                    System.out.println("Enter Drop Point");
                    char dropPoint=in.next().charAt(0);
                    System.out.println("Enter Pickup time");
                    int pickupTime=in.nextInt();
                    booking.setCustomerId(customerId);
                    booking.setPickupPoint(pickupPoint);
                    booking.setDropPoint(dropPoint);
                    booking.setPickupTime(pickupTime);
                    if (pickupPoint < 'A' || pickupPoint > 'F' || dropPoint > 'F' ||dropPoint < 'A') {
                        System.out.println("Valid pickup and drop are A, B, C, D, E, F.Exiting");
                        break;
                    }

                    List<Taxi> freeTaxis=CreateTaxis.getFreeTaxis(taxis,pickupTime,pickupPoint);
                    if(freeTaxis.size()==0){
                        System.out.println("No Taxi can be alloted.Exitting");
                        return;
                    }
                    Collections.sort(freeTaxis,(a, b)-> (int) (a.getTotalEarnings()-b.getTotalEarnings()));
                    MakeBooking.makeBooking(id,pickupPoint,dropPoint,pickupTime,freeTaxis);
                    id++;
                    break;
                case 2:
                    for(Taxi t:taxis){
                        System.out.println(t.toString());
                    }

                         Trip.printDetails(taxis);
                    break;
                case 3:
                    return;
            }
        }
    }


}
