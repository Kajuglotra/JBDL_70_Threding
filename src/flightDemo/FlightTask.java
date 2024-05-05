package flightDemo;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.Date;

public class FlightTask implements Callable<List<FlightData>> {

    private String src;
    private String dest;
    private Date jDate;
    private FlightService service;

    public FlightTask(String src, String dest, Date jDate, FlightService service) {
        this.src = src;
        this.dest = dest;
        this.jDate = jDate;
        this.service = service;
    }

    @Override
    public List<FlightData> call() throws Exception {
       return service.getFlights(src, dest, jDate);
    }
}
