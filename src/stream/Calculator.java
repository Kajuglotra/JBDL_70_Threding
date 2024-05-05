package stream;


@FunctionalInterface
public interface Calculator {

    int add(int a, int b);

    default int multiply(int a, int b){
        return a*b;
    }
}
