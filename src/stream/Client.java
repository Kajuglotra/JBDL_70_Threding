package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        Calculator c = new Calculator() {
            @Override
            public int add(int a, int b) {
                System.out.println("I am in anonymous class");
                return a+b;
            }
        };

        // lambda exp -> implementation of only functional interfaces
        Calculator c2 = (a, b) -> a+b;
        Calculator c1 = (a, b)-> {
            System.out.println("I am in anonymous class");
            return a+b;
        };

        System.out.println(c1.add(2,4));

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(50);
        list.add(60);
        list.add(80);
        list.add(90);

        System.out.println(Collections.binarySearch(list, 20, Collections.reverseOrder()));
    }
}
