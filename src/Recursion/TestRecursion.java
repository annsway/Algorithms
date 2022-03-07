package Recursion;

public class TestRecursion {
//    public int passInt(int target) {
//        if (target == 0) {
//            return 1;
//        }
//        passInt(target - 1);
//        return target * (target -1);
//    }
//
//    public void passObj() {
//
//    }

    public static int sum(int[] array) {
        return sum(array, 0, 0);
    }

    private static int sum(int[] array, int idx, int acc) {
        if (idx == array.length) {
            return acc;
        }
        return sum(array, idx + 1, acc + array[idx]);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        System.out.println(sum(array));
    }

}
