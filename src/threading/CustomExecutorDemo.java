package threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomExecutorDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 9, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        Task task = new Task();

        for(int i = 0 ; i< 200;i++){
            executor.submit(task);
        }
        executor.shutdown();
    }
}
