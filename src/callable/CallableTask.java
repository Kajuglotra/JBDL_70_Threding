package callable;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<String> {
    // multithreaded pattern
    @Override
    public String call() throws Exception {
        return "I am in call method " + Thread.currentThread().getName();
    }
}
