package com.testing;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class FlightsFilterTest {

    LocalDateTime myTime = LocalDateTime.now();
    List<Flight> flights = new ArrayList<>(List.of(
            new Flight(List.of(
                    new Segment(myTime.minusDays(1), myTime.minusHours(2)),
                    new Segment(myTime.plusDays(1), myTime.plusDays(1).plusHours(2)))),
            new Flight(List.of(
                    new Segment(myTime.plusDays(1).plusHours(5),
                            myTime.plusDays(2)))),
            new Flight(List.of(
                    new Segment(myTime.plusDays(3), myTime.plusDays(3).minusHours(2)),
                    new Segment(myTime.plusDays(3).plusHours(5),
                            myTime.plusDays(3).plusHours(8))))
    ));

    @Test
    void whenNullListdepartureAfterNow() {
        List<Flight> flights1 = null;
        List<Flight> expected = new ArrayList<>();
        List<Flight> result = FlightsFilter.departureAfterNow(flights1);
        assertIterableEquals(result, expected);
    }

    @Test
    void whenRemoveFirstfrom3FlightsDepartureAfterNow() {
        List<Flight> expected = List.of(
                new Flight(List.of(
                        new Segment(myTime.plusDays(1).plusHours(5),
                                myTime.plusDays(2)))),
                new Flight(List.of(
                        new Segment(myTime.plusDays(3), myTime.plusDays(3).minusHours(2)),
                        new Segment(myTime.plusDays(3).plusHours(5),
                                myTime.plusDays(3).plusHours(8))))
        );
        List<Flight> result = FlightsFilter.departureAfterNow(flights);
        assertIterableEquals(result, expected);
    }


    @Test
    void whenNullListArrivalAfterDeparture() {
        List<Flight> flights1 = null;
        List<Flight> expected = new ArrayList<>();
        List<Flight> result = FlightsFilter.arrivalAfterDeparture(flights1);
        assertIterableEquals(result, expected);
    }

    @Test
    void whenRemoveThirdfrom3ArrivalAfterDeparture() {
        List<Flight> expected = new ArrayList<>(List.of(
                new Flight(List.of(
                        new Segment(myTime.minusDays(1), myTime.minusHours(2)),
                        new Segment(myTime.plusDays(1), myTime.plusDays(1).plusHours(2)))),
                new Flight(List.of(
                        new Segment(myTime.plusDays(1).plusHours(5),
                                myTime.plusDays(2))))
        ));
        List<Flight> result = FlightsFilter.arrivalAfterDeparture(flights);
        assertIterableEquals(result, expected);
    }

    @Test
    void whenNullListTimeOnEarthLessThan2Hours() {
        List<Flight> flights1 = null;
        List<Flight> expected = new ArrayList<>();
        List<Flight> result = FlightsFilter.timeOnEarthLessThan2Hours(flights1);
        assertIterableEquals(result, expected);
    }

    @Test
    void whenRemoveFirstandThirdfrom3TimeonEarthLessThan2Hours() {
        List<Flight> expected = new ArrayList<>(List.of(
                new Flight(List.of(
                        new Segment(myTime.plusDays(1).plusHours(5),
                                myTime.plusDays(2))))
        ));
        List<Flight> result = FlightsFilter.timeOnEarthLessThan2Hours(flights);
        assertIterableEquals(result, expected);
    }
}