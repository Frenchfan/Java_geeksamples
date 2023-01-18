package com.gridnine.testing;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class FlightsFilterTest {

    LocalDateTime currentTime = LocalDateTime.now();
    List<Flight> flights = new ArrayList<>(List.of(
            new Flight(List.of(
                    new Segment(currentTime.minusDays(1), currentTime.minusHours(2)),
                    new Segment(currentTime.plusDays(1), currentTime.plusDays(1).plusHours(2)))),
            new Flight(List.of(
                    new Segment(currentTime.plusDays(1).plusHours(5),
                            currentTime.plusDays(2)))),
            new Flight(List.of(
                    new Segment(currentTime.plusDays(3), currentTime.plusDays(3).minusHours(2)),
                    new Segment(currentTime.plusDays(3).plusHours(5),
                            currentTime.plusDays(3).plusHours(8))))
    ));

    @Test
    void whenNullListDepartureAfterNow() {
        List<Flight> expected = new ArrayList<>();
        List<Flight> result = FlightsFilter.departureAfterNow(null);
        assertIterableEquals(result, expected);
    }

    @Test
    void whenRemoveFirstfrom3FlightsDepartureAfterNow() {
        List<Flight> expected = List.of(
                new Flight(List.of(
                        new Segment(currentTime.plusDays(1).plusHours(5),
                                currentTime.plusDays(2)))),
                new Flight(List.of(
                        new Segment(currentTime.plusDays(3), currentTime.plusDays(3).minusHours(2)),
                        new Segment(currentTime.plusDays(3).plusHours(5),
                                currentTime.plusDays(3).plusHours(8))))
        );
        List<Flight> result = FlightsFilter.departureAfterNow(flights);
        assertIterableEquals(result, expected);
    }


    @Test
    void whenNullListArrivalAfterDeparture() {
        List<Flight> expected = new ArrayList<>();
        List<Flight> result = FlightsFilter.arrivalAfterDeparture(null);
        assertIterableEquals(result, expected);
    }

    @Test
    void whenRemoveThirdfrom3ArrivalAfterDeparture() {
        List<Flight> expected = new ArrayList<>(List.of(
                new Flight(List.of(
                        new Segment(currentTime.minusDays(1), currentTime.minusHours(2)),
                        new Segment(currentTime.plusDays(1), currentTime.plusDays(1).plusHours(2)))),
                new Flight(List.of(
                        new Segment(currentTime.plusDays(1).plusHours(5),
                                currentTime.plusDays(2))))
        ));
        List<Flight> result = FlightsFilter.arrivalAfterDeparture(flights);
        assertIterableEquals(result, expected);
    }

    @Test
    void whenNullListTimeOnEarthLessThan2Hours() {
        List<Flight> expected = new ArrayList<>();
        List<Flight> result = FlightsFilter.timeOnEarthLessThan2Hours(null);
        assertIterableEquals(result, expected);
    }

    @Test
    void whenRemoveFirstandThirdfrom3TimeonEarthLessThan2Hours() {
        List<Flight> expected = new ArrayList<>(List.of(
                new Flight(List.of(
                        new Segment(currentTime.plusDays(1).plusHours(5),
                                currentTime.plusDays(2))))
        ));
        List<Flight> result = FlightsFilter.timeOnEarthLessThan2Hours(flights);
        assertIterableEquals(result, expected);
    }
}