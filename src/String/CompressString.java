package String;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class CompressString {
    public String compress(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        int slow = 0;
        int fast = 0;
        char[] array = input.toCharArray();
/**      0 1 2 3 4 5 6 7 8 9
         a 3 b 2 c c d e e e
                 s
                       f
                             f2                        */
        while (fast < array.length) {
            int fast2 = fast;
            while (fast2 < array.length && array[fast] == array[fast2]) {
                fast2++;
            }
            if (fast2 - fast == 1) { // meaning there's only one char in this segment
                array[slow++] = array[fast++];
            } else {
                array[slow++] = array[fast];
                int count = fast2 - fast;
                String cnt = Integer.toString(count);
                for (int i = 0; i < cnt.length(); i++) {
                    array[slow++] = cnt.charAt(i);
                }
                fast = fast2;
            }
        }
        return new String(Arrays.copyOfRange(array, 0, slow));
    }

    public static void main(String[] args) {
        CompressString sol = new CompressString();
        System.out.println(sol.compress("aaabccdeee")); //Expected: ["a3bc2de3"]
    }
}
