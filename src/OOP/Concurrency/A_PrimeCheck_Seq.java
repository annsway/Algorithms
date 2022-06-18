package OOP.Concurrency;

/** This is an example of a *sequential* program, i.e. one that does not <br>
 * use any concurrency or parallelism. It checks two numbers to see whether <br>
 * they're prime. (It does this in an intentionally inefficient way; there are <br>
 * much better ways to check whether numbers are prime!) See the next program <br>
 * for a version that runs the checks in parallel threads. */
public class A_PrimeCheck_Seq {
    public static void main(String[] args) {
        System.out.println("starting...");

        var check1= new PrimeCheck(93877037L);
        check1.run();

        var check2= new PrimeCheck(93877039L);
        check2.run();

        System.out.println("done!");
    }
}

/** An object that can check a single integer for primality. */
class PrimeCheck {
    private long num; // The integer being checked.

    /** Create a new prime checker for a particular number. */
    public PrimeCheck(long n) {
        num= n;
    }

    /** Run the primality check and print the result to System.out. */
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
