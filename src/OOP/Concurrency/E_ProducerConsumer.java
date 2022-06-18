package OOP.Concurrency;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/** This example demonstrates the "producer/consumer" pattern for parallel programs.<br>
 * The producer creates work for the consumer to process and puts it into a queue; <br>
 * the consumer loops infinitely, waiting for something to appear in the queue and <br>
 * then processes it. */
public class E_ProducerConsumer {
    public static void main(String[] args) {
        Queue<Long> queue= new ConcurrentLinkedQueue<>();
        var producerThread= new Thread(new PrimeProducer(queue, 189877));
        var consumerThread= new Thread(new NumberPrinter(queue, "is prime!"));

        producerThread.start();
        consumerThread.start();
    }
}

/** Produce prime numbers and put them in a processing queue. */
class PrimeProducer implements Runnable {
    Queue<Long> queue;
    long num;

    /** Create a producer that puts items in queue q. <br>
     * Prime numbers will start at `start`. */
    public PrimeProducer(Queue<Long> q, long start) {
        queue= q;
        num= start;
    }

    /** Check whether a num is prime. */
    private boolean isPrime(long num) {
        for (var i= 2L; i < num; ++i) {
            if (num % i == 0) { return false; }
        }
        return true;
    }

    @Override
    public void run() {
        while (true) {
            if (isPrime(num)) {
                // Send the prime to the consumer.
                queue.add(num);
            }

            // Try the next number.
            num++ ;
        }
    }
}

/** A consumer that reads numbers from a queue and prints them. */
class NumberPrinter implements Runnable {
    Queue<Long> queue;
    String message;

    /** Create a printer that reads numbers from queue q and prints <br>
     * them followed by message. */
    public NumberPrinter(Queue<Long> q, String message) {
        queue= q;
        this.message= message;
    }

    @Override
    public void run() {
        while (true) {
            // Get a prime from the producer.
            synchronized (queue) {
                if (!queue.isEmpty()) {
                    long p= queue.remove();
                    System.out.println(p + " " + message);
                }
            }
        }
    }
}
