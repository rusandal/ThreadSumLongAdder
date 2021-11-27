import java.util.concurrent.atomic.LongAdder;

public class Main {
    public static void main(String[] args) {
        LongAdder stat = new LongAdder();
        Shop shop1 = new Shop();
        Shop shop2 = new Shop();
        Shop shop3 = new Shop();
        Thread thread1 = new Thread(null, () -> shop1.send(stat), "Магазин 1");
        Thread thread2 = new Thread(null, () -> shop2.send(stat), "Магазин 2");
        Thread thread3 = new Thread(null, () -> shop3.send(stat), "Магазин 3");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Сумма по магазинам = " + stat.sum());


    }
}
