package threading;

public class Task2 extends Thread{

    @Override
    public void run(){
        System.out.println("kajal "+ Thread.currentThread());
    }
}
