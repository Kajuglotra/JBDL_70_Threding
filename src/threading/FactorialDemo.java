package threading;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class FactorialDemo {

    public static void main(String[] args) {
        // nQ > 10000
        List<Integer> l = Arrays.asList(10000,20000,30000,40000,50000,60000,70000,80000,90000,100000);
        long startTime =System.currentTimeMillis();
        l.stream().parallel().map(item -> getFactorial(item)).forEach(item -> System.out.println("factorial for the given num  is done by thread : " + Thread.currentThread()));
        long endTime =System.currentTimeMillis();
        System.out.println("Time taken: " +(endTime-startTime));
    }

    public static BigInteger getFactorial(int num){
        BigInteger output = BigInteger.ONE;
        for(int i = 2; i<=num;i++){
            output= output.multiply(BigInteger.valueOf(i));
        }
        return output;
    }
}
