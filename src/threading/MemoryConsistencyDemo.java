package threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MemoryConsistencyDemo {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        TaskForMemeoryConsIssue task1 = new TaskForMemeoryConsIssue("W");
        TaskForMemeoryConsIssue task2 = new TaskForMemeoryConsIssue("R");

        service.submit(task1);
        service.submit(task2);
        service.shutdown();
    }
}
