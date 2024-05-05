package threading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FactorialClient {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//        List<Integer> l = Arrays.asList(10000,20000,30000,40000,50000,60000,70000,80000,90000,100000,120000, 130000, 14000);
//        List<Integer> l = Arrays.asList(100000,200000,300000,400000,500000,600000,700000,800000,900000,1000000);
        // 10 threads are getting initiated
        long startTime =System.currentTimeMillis();
        List<Thread> listOfThread = new ArrayList<>();
        l.stream().forEach(item -> {
            // runnable
            MultiThreadFactorial runnable = new MultiThreadFactorial(item);
            Thread thread = new Thread(runnable);
            thread.start();
            // 10 threads have been created and added to the list
            listOfThread.add(thread);
        });
        listOfThread.stream().forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        long endTime = System.currentTimeMillis();
        // main thread
        System.out.println("Time taken: " +(endTime-startTime));
    }
}

// factorial again at your home with the same input

//single threaded prog : 9
// multi threaded : 9 sec == single thread

// multi threaded : 4



// parallel stream : multithreading only // u are not deciding hoe many should be there ?
// cores >= no of threads

// multi threading -> how many threads should be there

// task -> 8 threads -> 8 cores in total
// i am creating 16 threads instead of 8
// switching will be there
// multi threaded prog may take more time than parallel stream prog




