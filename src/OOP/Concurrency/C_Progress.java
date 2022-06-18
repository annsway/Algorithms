package OOP.Concurrency;

/** This version of the parallel prime-check program uses an extra <br>
 * thread to monitor the progress of the primality-checking thread. <br>
 * It shows how to use a Boolean variable, called "done" here, <br>
 * to signal to the progress-checking thread that it's time to exit. */
public class C_Progress {
    public static void main(String[] args) {
        var check= new PrimeCheckP(93877037L);

        var checkThread= new Thread(check);
        var progressThread= new Thread(new Progress(check));

        progressThread.start();
        checkThread.start();
    }
}

class PrimeCheckP implements Runnable {
    private long num;  // The integer to check.
    public long k;  // The divisor currently being checked.
    public boolean done;  // Done checking the number?

    public PrimeCheckP(long n) {
        num= n;
        k= 0;
        done= false;
    }

    @Override
    public void run() {
        for (k= 2; k < num; ++k) {
            if (num % k == 0) {
                System.out.println(num + " is composite: divisible by " + k);
                done= true;
                return;
            }
        }
        System.out.println(num + " is prime!");
        done= true;
    }
}

/** Periodically check on the progress of a PrimeCheckP, printing out the largest divisor it has
 * checked so far. */
class Progress implements Runnable {
    private PrimeCheckP check;

    /** Create a progress monitor for a given prime check. */
    public Progress(PrimeCheckP check) {
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

            // Exit the thread when the number check is done.
            if (check.done) {
                break;
            }

            System.out.println("checked up to " + check.k + "...");
        }
    }
}
