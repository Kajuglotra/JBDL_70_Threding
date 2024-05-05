package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    // 1,2,3,4,5,6,7,8,9,10
    // check first that the num is even or not
    // square of that even num and return me the sum of all num

    // 4+16+36+64+100 = 220
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int sum =0;
        //iterative way of doing this code
        for(int i =0 ;i < list.size(); i++){
            if(list.get(i)%2 == 0){
                sum+= list.get(i)*list.get(i);
            }
        }
        System.out.println("sum with iterative way is " + sum);

        //declarative way of writing the code
         Optional<Integer> output = list.parallelStream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                System.out.println("I am in test method");
                return integer%2==0;
            }
        }).map(new Function<Integer, Integer>() {
             @Override
             public Integer apply(Integer integer) {
                 System.out.println("I am in apply method of map");
                 return integer * integer;
             }
         })
//                 .reduce(1, new BinaryOperator<Integer>() {
//                 @Override
//                 public Integer apply(Integer integer, Integer integer2) {
//                     System.out.println("I am in apply method of reduce");
//                     return integer+integer2;
//                 }
//             });

//
                 .reduce(new BinaryOperator<Integer>() {
             @Override
             public Integer apply(Integer integer, Integer integer2) {
                 System.out.println("I am in apply method of reduce");
                 return integer+integer2;
             }
         });



        // n no of intermediate operation
        // 1 terminal operation

        System.out.println("sum with declarative way is " + output);

        int output1  = list.stream().
                filter(integer -> integer%2==0).
                map(integer -> integer*integer).
                reduce(0, (integer, integer2) ->integer+integer2);

        System.out.println("sum with lambda exp  is " + output1);
    }
}
