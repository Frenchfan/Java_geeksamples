package com.gridnine.testing;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Flight> myFlights = FlightBuilder.createFlights();
        myFlights.forEach(System.out::println);
        System.out.println("***********");
        List<Flight> firstList = FlightsFilter.departureAfterNow(myFlights);
        firstList.forEach(System.out::println);
        System.out.println("***********");
        List<Flight> secondList = FlightsFilter.arrivalAfterDeparture(myFlights);
        secondList.forEach(System.out::println);
        System.out.println("***********");
        List<Flight> thirdList = FlightsFilter.timeOnEarthLessThan2Hours(myFlights);
        thirdList.forEach(System.out::println);
    }
}
