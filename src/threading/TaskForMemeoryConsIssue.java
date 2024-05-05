package threading;

import java.util.concurrent.atomic.AtomicInteger;

public class TaskForMemeoryConsIssue implements Runnable{

    private String type;

    static AtomicInteger data = new AtomicInteger(0);

    public TaskForMemeoryConsIssue(String type) {
        this.type = type;
    }

    @Override
    public void run() {
        if(type.equalsIgnoreCase("W")){
            while(data.get() != 5){
                data.getAndAdd(1); //1, 2
                System.out.println("wrote data :" + data);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }else{
            int temp = 0;
            while (true){
                if(temp != data.get()){
                    System.out.println("read data: " + data);
                    temp =data.get();
                }
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            }
        }
    }
}
