package OOP.Concurrency;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class F_ProducerConsumer_Multiple {
    /** Create a queue to hold integers.<br>
     * Create a producer: a thread that creates integers and puts them on the queue.<br>
     * Create three consumers: each repeatedly takes an integer off the queue and prints whether it
     * is prime.<br>
     * Parameter args is not used. */
    public static void main(String[] args) {
        Queue<Long> queue= new ConcurrentLinkedQueue<>();
        var producerThread= new Thread(new PrimeProducer(queue, 189877));
        var consumer1= new Thread(new NumberPrinter(queue, "is prime!"));
        var consumer2= new Thread(new NumberPrinter(queue, "is prime!"));
        var consumer3= new Thread(new NumberPrinter(queue, "is prime!"));

        producerThread.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }
}
