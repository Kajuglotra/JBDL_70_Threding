package threading;

import java.util.stream.Stream;

public class Task implements Runnable{
    @Override
    public void run() {

        System.out.println("kajal "+ Thread.currentThread());
    }
}
