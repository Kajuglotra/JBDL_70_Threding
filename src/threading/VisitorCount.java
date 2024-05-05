package threading;

import java.util.concurrent.atomic.AtomicInteger;

public class VisitorCount implements Runnable{
    private AtomicInteger count;

    public VisitorCount() {
        this.count = new AtomicInteger(0);
    }

    @Override
    public void run() {
        count.getAndAdd(1);
    }
    // waiting thread
//    public synchronized void addCount(){
//        count++;
//    }

    public int getCount() {
        return count.get();
    }
}
