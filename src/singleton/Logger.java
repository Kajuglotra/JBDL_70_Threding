package singleton;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Logger {
//    Runnable
//    Callable

    private static Logger instance= new Logger();
    private Logger(){
    }
// t1, t2, t3, t4
    public static Logger getInstance(){
//        t1 and t2, t3, t4
        if(instance == null) {
            // t1 and t2
            synchronized(Logger.class){
                if(instance == null){
                    // t1 will create an instance of logger
                    instance = new Logger();
                }
            }
            // 2 threads try to create object of logger class at the exact same time
        }
        return instance;
    }
    public void printMsg(String msg){
        System.out.println(msg);
    }

    public static void main(String[] args) {
        Logger logger = Logger.instance;
        Logger logger1 = Logger.instance;

        logger1.printMsg("my message is done");

        HashMap<Logger,Logger> hashMap = new HashMap<>();

    }


}

//lazy initialization
// early

// prob (race cond)
// 1) synchronized -> allow one thread to go in -> this is not the perfect sol
// 2) if i am doing early initialization , will the prob of race condn comes to us ?
// make the class early initialized ? -> this is not the perfect sol

// 3)

