package Array;

public class MakeIncreasingArray {
    boolean solution(int[] a) {
        boolean flag = false;
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] >= a[i]) {
                if (flag) {
                    return false; // already swapped once
                } else {
                    int res1 = i + 1 < a.length ? getSmaller(a[i], a[i - 1], a[i + 1]) : getSmaller(a[i], a[i - 1], Integer.MAX_VALUE) ;
                    int res2 = i - 2 >= 0 ? getGreater(a[i - 1], a[i - 2], a[i]) : getGreater(a[i - 1], Integer.MIN_VALUE, a[i]);
                    if (res1 == -1 && res2 == -1) {
                        return false;
                    } else {
                        flag = true;
                        a[i] = res1 == -1 ? res2 : res1;
                    }
                }
            }
        }
        return true;
    }

    int getSmaller(int num, int min, int max) {
        char[] a = String.valueOf(num).toCharArray();
        for (int left = 0; left < a.length; left++) {
            for (int right = a.length - 1; right >= 0; right--) {
                if (a[left] > a[right]) {
                    swap(a, left, right);
                    int new_num = Integer.parseInt(String.valueOf(a));
                    if (new_num > min && new_num < max) {
                        System.out.println("new_num: " + new_num + " min: " + min + " max: " + max);
                        return new_num;
                    }
                }
            }
        }
        return -1;
    }

    int getGreater(int num, int min, int max) {
        char[] a = String.valueOf(num).toCharArray();
        for (int left = 0; left < a.length; left++) {
            for (int right = a.length - 1; right >= 0; right--) {
                if (a[left] < a[right]) {
                    swap(a, left, right);
                    int new_num = Integer.parseInt(String.valueOf(a));
                    if (new_num > min && new_num < max) {
                        System.out.println("new_num: " + new_num + " min: " + min + " max: " + max);
                        return new_num;
                    }
                }
            }
        }
        return -1;
    }

    void swap(char[] a, int left, int right) {
        char temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }

    public static void main(String[] args) {
        MakeIncreasingArray sol = new MakeIncreasingArray();

        int[] arr1 = {1, 5, 10, 20};
        System.out.println(sol.solution(arr1)); // true

        int[] arr2 = {13, 31, 30};
        System.out.println(sol.solution(arr2)); // false

        int[] arr3 = {1, 3, 900, 10};
        System.out.println(sol.solution(arr3)); // true
    }
}
