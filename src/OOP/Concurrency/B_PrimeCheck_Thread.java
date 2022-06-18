package OOP.Concurrency;

/** This is a multi-threaded version of the first program. <br>
 * It runs the two checks for primality in separate threads <br>
 * (distinct from the main thread). */
public class B_PrimeCheck_Thread {
    public static void main(String[] args) {
        System.out.println("starting...");

        var check1= new PrimeCheckR(93877037L);
        var thread1= new Thread(check1);
        thread1.start();

        var check2= new PrimeCheckR(93877039L);
        var thread2= new Thread(check2);
        thread2.start();

        System.out.println("done!");
    }
}

/** An object that can check a single integer for primality. */
class PrimeCheckR implements Runnable {
    private long num;

    /** Create a new prime checker for integer n. */
    public PrimeCheckR(long n) {
        num= n;
    }

    /** Run the primality check and print the result to System.out. */
    @Override
    public void run() {
        // Try every divisor from 2 to num - 1.
        // invariant: num is not divisible by an integer in 2..k-1
        for (var k= 2L; k < num; ++k) {
            // If num is divisible by k, it's not prime.
            if (num % k == 0) {
                System.out.println(num + " is composite: divisible by " + k);
                return;
            }
        }

        // num is not divisible by an integer in 2..num-1
        System.out.println(num + " is prime!");
    }
}
