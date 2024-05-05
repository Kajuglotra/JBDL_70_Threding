package threading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Client {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        Task task = new Task();
        Thread thread = new Thread(task);
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread.start();
        thread1.start();
        thread2.start();
//        thread.start();

        Thread t = new Task2();
        t.start();
        ArrayList<Integer> l = new ArrayList();
        l.add(10);
        l.add(20);
        l.add(30);
        System.out.println(Collections.binarySearch(l, 20, Collections.reverseOrder()));

    }
}

// Steps to run a task in multi threaded pattern
// 1st  way
// 1) create class implements the runnable
// 2) you must have provide body to run method
// 3) whatever you want to achieve in multi threaded pattern, write it in the run method
// 4) create an object of that runnable
// 5) Create a thread with runnable
// 6 ) start the thread

// 2nd way
// 1) create a class extends Thread class
// 2) provide the run method(this is mandatory, however the class u to do this)
//3) whatever you want to achieve in multi threaded pattern, write it in the run method
// 4) create an object of that class
// 5) start the thread
