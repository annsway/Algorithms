package DP;

public class CountSawtoothSubstrings {
    public static int count(int[] arr) {
        int n = arr.length;
        int totalCount = 0;
        int prevCount = 0;
        boolean goingUp;

        for (int curIdx = 1; curIdx < n; curIdx++) {
            int curCount;
            int prevIdx = curIdx - 1;

            if (arr[curIdx] > arr[prevIdx]) {
                goingUp = true;
            } else if (arr[curIdx] < arr[prevIdx]) {
                goingUp = false;
            } else {
                continue;
            }
            // if we made it here, we have at least one sawtooth
            curCount = 1;

            // DP: see if there was a previous solution
            // and if it continues our current sawtooth
            // prevIdx < 1 代表着目前只有 2 个端点，即最开始的两个
            if (prevIdx >= 1) {
                if (goingUp) {
                    if (arr[prevIdx - 1] > arr[prevIdx]) {
                        curCount += prevCount;
                    }
                } else {
                    if (arr[prevIdx - 1] < arr[prevIdx]) {
                        curCount += prevCount;
                    }
                }
            }
            prevCount = curCount; // update prevCount
            totalCount += curCount;
            System.out.println("curIdx: " + curIdx + " curCount: " + prevCount + " totalCount: " + totalCount);
        }
        return totalCount;
    }

    public static void main(String[] args) {
        System.out.println(CountSawtoothSubstrings.count(new int[]{1, 2, 1, 2, 1}));
//        System.out.println(CountSawtoothSubstrings.count(new int[]{10, 10, 10}));
//        System.out.println(CountSawtoothSubstrings.count(new int[]{9, 8, 7, 6, 5}));

    }
}
