package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> myFlights = FlightBuilder.createFlights();
        System.out.println("List of flights for testing: ");
        myFlights.forEach(System.out::println);
        System.out.println();
        System.out.println("Flights with departure after now only");
        List<Flight> firstList = FlightsFilter.departureAfterNow(myFlights);
        firstList.forEach(System.out::println);
        System.out.println();
        System.out.println("Flights with arrival after departure");
        List<Flight> secondList = FlightsFilter.arrivalAfterDeparture(myFlights);
        secondList.forEach(System.out::println);
        System.out.println();
        System.out.println("Flights with time on earth equal or less than 2 hours (interval between the arrival of the first segment\n" +
                "     and departure of the second)");
        List<Flight> thirdList = FlightsFilter.timeOnEarthLessThan2Hours(myFlights);
        thirdList.forEach(System.out::println);
    }
}
