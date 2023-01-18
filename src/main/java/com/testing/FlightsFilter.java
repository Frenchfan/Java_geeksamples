package com.testing;
import java.time.LocalDateTime;
import java.util.*;

public class FlightsFilter {
    /**
     * @param flights - List<Flight>
     * @return flights with departure after now only, uses parallelStream (Stream API)
     */
    public static List<Flight> departureAfterNow(List<Flight> flights) {
        return Optional.ofNullable(flights)
                .orElseGet(ArrayList::new)
                .parallelStream()
                .filter(y -> y.getSegments()
                        .stream()
                        .allMatch(x-> x.getDepartureDate()
                                .isAfter(LocalDateTime.now())))
                .toList();
    }

    /**
     * @param flights - List<Flight>
     * @return flights with arrival after departure, uses parallelStream (Stream API)
     */
    public static List<Flight> arrivalAfterDeparture(List<Flight> flights) {
        return Optional.ofNullable(flights)
                .orElseGet(Collections::emptyList)
                .parallelStream()
                .filter(y -> y.getSegments()
                        .stream()
                        .allMatch(x-> x.getArrivalDate()
                                .isAfter(x.getDepartureDate())))
                .toList();
    }

    /**
     * @param flights - List<Flight>
     * @return flights with time on earth equal or less than 2 hours (interval between the arrival of the first segment
     * and departure of the second)
     */
    public static List<Flight> timeOnEarthLessThan2Hours(List<Flight> flights) {
        if (flights == null) return new ArrayList<>();
        List<Flight>myFlights = new ArrayList<>(flights);
        ListIterator<Flight> iterator = myFlights.listIterator();
        while (iterator.hasNext()) {
            Flight flight = iterator.next();
            List<Segment> segments = flight.getSegments();
            for (int i = 0; i < segments.size() - 1; i++) {
                if (segments.get(i).getArrivalDate().plusHours(2).plusMinutes(1).isBefore(
                        segments.get(i + 1).getDepartureDate())) {
                    iterator.remove();
                }
            }
        }
        return myFlights;
    }
}
