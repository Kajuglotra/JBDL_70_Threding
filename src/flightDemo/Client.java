package flightDemo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<FlightService> listOfFlightService = new ArrayList<>();


        FlightService service1 = new AirIndiaFlightServiceImpl();
        FlightService service2 = new VistaraFlightServiceImpl();
        FlightService service3 = new IndigoFlightServiceImpl();

        listOfFlightService.add(service1);
        listOfFlightService.add(service2);
        listOfFlightService.add(service3);

        FlightTask task1 = new FlightTask("delhi", "goa", new Date(), service1);
        FlightTask task2 = new FlightTask("delhi", "goa", new Date(), service2);
        FlightTask task3 = new FlightTask("delhi", "goa", new Date(), service3);

        ExecutorService service = Executors.newFixedThreadPool(listOfFlightService.size());
        // 1st way, submitting tasks independently, then collecting output in list

        List<Future<List<FlightData>>> result = new ArrayList<>();
        Future<List<FlightData>> f1 = service.submit(task1);
        Future<List<FlightData>> f2 = service.submit(task2);
        Future<List<FlightData>> f3 = service.submit(task3);
        result.add(f1);
        result.add(f2);
        result.add(f3);


        // 2nd way, list of callables first and then calling invoke all
        List<Callable<List<FlightData>>> list = new ArrayList<>();
        list.add(task2);
        list.add(task1);
        list.add(task3);

        List<Future<List<FlightData>>> result1 = service.invokeAll(list);

        result1.stream().forEach(data -> {
            try {
                System.out.println(data.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
// homework
// calculate how much time is it taking to execute the method ?
// we are doing it in multi threaded prog, parallel stream

// till next week:
// mysql (successful) username, password
// u have to check how can u configure the port of db
