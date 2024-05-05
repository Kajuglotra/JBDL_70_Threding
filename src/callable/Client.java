package callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableTask callableTask = new CallableTask();
        // callable cannot create an object of thread class
        // callable can be useful only when u have execustorservice with u
//        Thread thread1 = new Thread(callableTask);
        ExecutorService service = Executors.newFixedThreadPool(4);
        // blocking call ?
        // future<String> is not making it blocking
        List<Future<String>> output = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for(int i = 0;i<20;i++){
           output.add(service.submit(callableTask));
        }

        output.stream().forEach(data -> {
            try {
                // data.get() --> blocking call
                System.out.println(data.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        service.shutdown();
        service.awaitTermination(10, TimeUnit.MINUTES);
        long endTime = System.currentTimeMillis();
        System.out.println("total time taken :" +(endTime-startTime));


    }
}

// u and mother is not well
// u are taking mother to hosp
// u dont have any money

// u go to ur friend
// friend does not have money
// u says that take my debit card with u 1111
// right now, the bank is with no money

// parallelism
// u are taking ur mother to hosp with ur friends empty card
// friend is going to another friend and getting some money
// friend submitting money to the bank

// at that time, u need to buy the medicines
// money was not present in the account
// u will wait, till the money is added to the account, so that u can make a txn


// list <string>
// list.get(0);
//list.get(1);

//List<future<String>
// 0 --> thread1 space
// 1 -> string
// 2 --> thread3 space
// 3 --> thread4 space
// 4 --> thread2 space