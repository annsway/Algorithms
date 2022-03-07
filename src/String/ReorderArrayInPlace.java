package String;

public class ReorderArrayInPlace {
    //    public int[] reorder(int[] array) {
//        if (array.length % 2 == 0) {
//            reorder(array, 0, array.length - 1);
//        } else {
//            reorder(array, 0, array.length - 2);
//        }
//        return array;
//    }
    public String reorder(String input) {
        char[] array = input.toCharArray();
        if (array.length % 2 == 0) {
            reorder(array, 0, array.length - 1);
        } else {
            reorder(array, 0, array.length - 2);
        }
        return new String(array);
    }

    private void reorder(char[] array, int left, int right) {
        int length = right - left + 1;
        if (length <= 2) {
            return;
        }
        int mid = left + length / 2;
        int lmid = left + length / 4;
        int rmid = mid + length / 4;
        reverse(array, lmid, mid - 1);
        reverse(array, mid, rmid - 1);
        reverse(array, lmid, rmid - 1);
        // newMid = left + (lmid - left) * 2
        int newMid = left + (lmid - left) * 2;
        reorder(array, left, newMid - 1);
        reorder(array, newMid, right);
    }

    private void reverse(char[] array, int left, int right) {
        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReorderArrayInPlace sol = new ReorderArrayInPlace();
//        int[] array = {0, 1, 2, 3, 4, 5};
//        int[] array = {0, 1};
        String str = "ABC123";
//        String str = "AB12";
        System.out.println(sol.reorder(str));

    }
}
