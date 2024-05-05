package threading;

import java.util.concurrent.ThreadFactory;

public class ThreadFactoryDemo implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r);
    }

    public static void main(String[] args) {
        ThreadFactoryDemo demo = new ThreadFactoryDemo();
        Task task = new Task();
        Thread t1 = demo.newThread(task);
        t1.start();


        Task2 task2 = new Task2();
        Thread t2 = demo.newThread(task2);
        t2.start();

    }
}
