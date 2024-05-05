package threading;

import java.util.concurrent.*;

public class ExecutorDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        ScheduledExecutorService executorService1 = Executors.newScheduledThreadPool(2);
        // runnable task ?
        Task task = new Task();
        String str = "result";
        System.out.println(executorService.submit(task,str).get());
        executorService1.schedule(task, 1, TimeUnit.MINUTES);

        Thread thread = new Thread(task);

        for(int i =0 ; i<2 ; i++){
            executorService.submit(task);
        }
        executorService.shutdown();
//        Thread.sleep(200);
//        executorService.shutdownNow();
        // this shutdown is a kind of signal that will be going to executor service ,that stop taking tasks after this.

//        executorService.submit(task);
        executorService.awaitTermination(10, TimeUnit.MICROSECONDS);

        // await termination will wait for at max the time which is mentioned in the timeout
        // if the tasks are done before timeout, main will move ahead.
        System.out.println("I am in main last line");
    }
}
