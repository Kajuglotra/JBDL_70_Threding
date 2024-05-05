package flightDemo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AirIndiaFlightServiceImpl implements FlightService{
    @Override
    public List<FlightData> getFlights(String src, String dest, Date jDate) {
       // third party air india
       List<FlightData> flights = new ArrayList<>();
       flights.add(new FlightData(src, dest, jDate, 200, "airIndia", 1));
       flights.add(new FlightData(src, dest, jDate, 200, "airIndia", 2));
       flights.add(new FlightData(src, dest, jDate, 200, "airIndia", 3));
       flights.add(new FlightData(src, dest, jDate, 200, "airIndia", 4));
       return flights;

    }
}
