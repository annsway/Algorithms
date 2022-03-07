package Array;

public class NumPairsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int remainders[] = new int[60];
        int count = 0;
        for (int t: time) {
            if (t % 60 == 0) { // check if a%60==0 && b%60==0
                count += remainders[0];
            } else { // check if a%60+b%60==60
                count += remainders[60 - t % 60];
            }
            remainders[t % 60]++; // remember to update the remainders
        }
        return count;
    }

    public static void main(String[] args) {
        NumPairsDivisibleBy60 sol = new NumPairsDivisibleBy60();
//        int[] time = {30,20,150,100,40};
        /**
         Output: 3
         Explanation: Three pairs have a total duration divisible by 60:
         (time[0] = 30, time[2] = 150): total duration 180
         (time[1] = 20, time[3] = 100): total duration 120
         (time[1] = 20, time[4] = 40): total duration 60
         * */
        int[] time = {60, 60, 60, 60};
        System.out.println(sol.numPairsDivisibleBy60(time));
    }
}
