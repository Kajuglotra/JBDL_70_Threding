package threading;

import java.math.BigInteger;

public class MultiThreadFactorial implements Runnable{
    private int num;

    public MultiThreadFactorial(int num){
        this.num = num;
    }

    @Override
    public void run() {
        getFactorial();
    }

    public  BigInteger getFactorial(){
        BigInteger output = BigInteger.ONE;
        for(int i = 2; i<=this.num;i++){
            output= output.multiply(BigInteger.valueOf(i));
        }
        System.out.println("factorial for the given num " +this.num+ " is done by thread : " + Thread.currentThread());
        return output;
    }

//    public int getFactorial(){
//        int output = 1;
//        for(int i = 2; i<=this.num;i++){
//            output= output*i;
//        }
//        System.out.println("factorial for the given num " +this.num+ " is :" + output+ " is done by thread : " + Thread.currentThread());
//        return output;
//    }
}
