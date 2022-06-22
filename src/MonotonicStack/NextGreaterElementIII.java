package MonotonicStack;

public class NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        /** idea:
         1. find the first smaller value to the monotonically increasing array from the end of the input array
         2. swap
         3. reverse */

        // convert int to array
        String s = Integer.toString(n);
        char[] a = new char[s.length()];
        for (int i = 0; i < a.length; i++) {
            a[i] = s.charAt(i);
        }

        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] < a[i + 1]) {
                int small = i;
                // find the smallest greater one
                int greater = i + 1;
                for (int j = i + 1; j < a.length; j++) {
                    if (a[i] < a[j] && a[j] <= a[greater]) {
                        greater = j;
                    }
                }
                swap(a, small, greater);
                reverse(a, small + 1, a.length - 1);
                break;
            }
        }
        try {
            int res = Integer.parseInt(new String(a));
            return res > n ? res : -1;
        } catch (Exception e) {
            return -1;
        }
    }

    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void reverse(char[] a, int start, int end) {
        while (start < end) {
            swap(a, start++, end--);
        }
    }

    public static void main(String[] args) {
        NextGreaterElementIII sol = new NextGreaterElementIII();
        System.out.println(sol.nextGreaterElement(12222333));
        // expected: 12223 233
        // actual:   12223 332
    }
}
