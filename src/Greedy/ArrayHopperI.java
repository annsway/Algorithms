package Greedy;

public class ArrayHopperI {
    public static boolean canJump1(int[] array) {
        // assumption: The given array is not null and has length of at least 1.
        // maxJump represents the max number of jumps you can jump forward at index i.
        int maxJump = array[0];
        // 重点: i represents the number of steps needed to reach index i.
        for (int i = 1; i < array.length; i++) {
            if (i > maxJump) {
                return false;
            }
            // maxJump--; // WRONG! Q: Why not decrement maxJump? A: Because i will increment in each step, which is equal to "decrement" the maxJump.
            // maxJump = Math.max(maxJump, array[i] + maxJump); // WRONG! test case = {4,2,1,1,0,4}
            maxJump = Math.max(maxJump, array[i] + i);
        }
        return true;
    }

    /** Method 2: TC = O(n^2), SC = O(n)
     * High-Level Idea:
     *
     * 1. canJump[i] represents whether or not we can jump to the end of the array at index i.
     *    - In other words, we do not need to check those checked spots anymore. We can take advantage of them directly in the following steps.
     *
     * 2. If we cannot reach to the end of the array directly at index i, we need to build a "bridge" to the checked spots
     *   to see if we can jump to any bridged spot that has been ensured to reach to the end of the array.
     *
     *   ...index i -> bridged (checked) spot -> end of array
     *
     *   Thus, we need to do a for loop to traverse every bridged spots that we can jump to from index i.
     *
     * 3. Note the semantic meanings of the following variables:
     *    (1) i represents the index to loop throw the array
     *    (2) array[i] represents the number of steps we can jump from 0 steps to array[i] steps.
     *
    */
    public static boolean canJump(int[] array) {
        if (array.length == 1) {
            return true;
        }
        boolean[] canJump = new boolean[array.length];
        for (int i = array.length - 2; i >= 0; i--) {
            if (i + array[i] >= array.length - 1) {
                canJump[i] = true;
            } else {
                for (int stepsForward = array[i]; stepsForward >= 1; stepsForward--) {
                    if (canJump[stepsForward + i]) {
                        canJump[i] = true;
                        break;
                    }
                }
            }
        }
        return canJump[0];
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{4,2,1,1,0,4}));
    }
}
