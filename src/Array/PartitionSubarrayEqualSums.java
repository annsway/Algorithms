package Array;

public class PartitionSubarrayEqualSums {
    public static int getMinEqualSumPartition(int N, int[] X) {
        // Assumption: the input array is not null or has a length of 0.
        if (N == 1) {
            return X[0];
        }
        int total = 0;
        for (int num : X) {
            total += num;
        }
        int possibleSum = 0;
        for (int i = 0; i < N; i++) {
            possibleSum += X[i];
            int nextSum = 0;
            for (int j = i + 1; j < N; j++) {
                nextSum += X[j];
                if (j == N - 1 && nextSum == possibleSum) { // base case
                    return possibleSum;
                }
                if (nextSum == possibleSum) {
                    nextSum = 0; // reset; enter the next subarray
                } else if (nextSum > possibleSum) {
                    break; // possibleSum is not equalSum
                }
            }
        }
        return total; // cannot partition the array
    }

    public static void main(String[] args) {
        System.out.println(getMinEqualSumPartition(6, new int[]{1,2,3,4,5,6}));
    }
}
