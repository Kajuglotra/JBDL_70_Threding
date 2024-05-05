package flightDemo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IndigoFlightServiceImpl implements FlightService{

    @Override
    public List<FlightData> getFlights(String src, String dest, Date jDate) {
        // third party air india
        List<FlightData> flights = new ArrayList<>();
        flights.add(new FlightData(src, dest, jDate, 200, "indigo", 9));
        flights.add(new FlightData(src, dest, jDate, 200, "indigo", 10));
        flights.add(new FlightData(src, dest, jDate, 200, "indigo", 11));
        flights.add(new FlightData(src, dest, jDate, 200, "indigo", 12));
        return flights;
    }
}
