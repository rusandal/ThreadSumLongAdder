import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class Shop {
    private int[] sold = new Random().ints(10, 400, 1000).toArray();

    public void send(LongAdder longAdder){
        for(int i:sold){
            longAdder.add(i);
        }
        System.out.println("Сумма выручки по "+ Thread.currentThread().getName() +" составила "+ Arrays.stream(sold).sum());
    }


}
