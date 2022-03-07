package String;

public class CompressStringII {
    public String compress(String input) {
        int singles = 0;
        char[] array = input.toCharArray();
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            int fast2 = fast;
            while (fast2 < array.length && array[fast] == array[fast2]) {
                fast2++;
            }
            if (fast2 - fast == 1) { // meaning there's only one char in this segment
                array[slow++] = array[fast++];
                singles++;
            } else {
                array[slow++] = array[fast];
                int count = fast2 - fast;
                String cnt = Integer.toString(count);
                for (int i = 0; i < cnt.length(); i++) {
                    array[slow++] = cnt.charAt(i);
                }
                fast = fast2; // 在 case2 里面
            }
        }
        // resize the array
        char[] array2 = new char[slow + singles]; //
        /**
         a b b c c c d e e e
         => a b 2 c 3 d e 3 e e
         => _ _ _ _ _ _ d 1 e 3
         i
         f
         */
        int f = slow - 1;
        // add 1s for single chars
        for (int i = array2.length - 1; i >= 0; i--) {
            if (f < 0) {
                break; // ?
            } else if (Character.isDigit(array[f])) {
                array2[i] = array[f--];
            } else if (!Character.isDigit(array[f]) && f != array.length - 1
                    && Character.isDigit(array[f + 1])) {
                array2[i] = array[f--];
            } else {
                array2[i--] = '1';
                array2[i] = array[f--];
            }
        }
        return new String(array2);
    }

    public static void main(String[] args) {
        CompressStringII sol = new CompressStringII();
        System.out.println(sol.compress("h"));
        System.out.println(sol.compress("sgw"));
        System.out.println(sol.compress("abbcccdeee")); // Expected: ["a1b2c3d1e3"]
    }
}
