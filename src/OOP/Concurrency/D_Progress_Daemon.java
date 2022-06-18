package OOP.Concurrency;

/** This example, like the last one, monitors the progress of a primality<br>
 * check, but it does not use a Boolean variable to tell the progress thread<br>
 * to shut down. Instead, it marks the thread as a "daemon", which means it<br>
 * automatically exits when the rest of the threads (i.e. the prime-checking<br>
 * thread and the main thread) exit. */
public class D_Progress_Daemon {
    public static void main(String[] args) {
        var check= new PrimeCheckD(93877037L);

        var checkThread= new Thread(check);
        var progressThread= new Thread(new ProgressD(check));

        // Mark the progress thread as a "daemon", so it automatically exits when
        // all the non-daemon threads in the process exit.
        progressThread.setDaemon(true);

        progressThread.start();
        checkThread.start();
    }
}

class PrimeCheckD implements Runnable {
    private long num;  // The integer to check.
    public long k;  // The divisor currently being check.

    public PrimeCheckD(long n) {
        num= n;
        k= 0;
    }

    @Override
    public void run() {
        for (k= 2; k < num; ++k) {
            if (num % k == 0) {
                System.out.println(num + " is composite: divisible by " + k);
                return;
            }
        }
        System.out.println(num + " is prime!");
    }
}

/** Periodically check on the progress of a PrimeCheckP, <br>
 * printing out the largest divisor it has checked so far. */
class ProgressD implements Runnable {
    private PrimeCheckD check;

    /** Create a progress monitor for a given prime check. */
    public ProgressD(PrimeCheckD check) {
        this.check= check;
    }

    /** Periodically print the largest divisor tested in the prime check. */
    @Override
    public void run() {
        while (true) {
            // Wait for a little while between print calls.
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}

            System.out.println("checked up to " + check.k + "...");
        }
    }
}
