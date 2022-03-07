package Array;

public class SolArray {
    public static void main(String[] args) {
        moveZero(new int[]{0, 0, 1});
    }
    public static int[] moveZero(int[] array) {
    /*
    i: [0, i): non-zeros
    j: [i, j]: confirmed zeros; j is the fast index to check if i should move forward
    (j, array.length - 1]: unchecked array
    {0, 0, 1, 1, 0, 1, 0}
     i
           j
    */
        int i = 0;
        int j = 1;
        while (j < array.length) {
            if (array[j] != 0) {
                if (i == 0 && array[i] != 0) {
                    i++;
                }
                swap(array, i, j);
                i++;
            }
            j++;
        }
        while (i < array.length) {
            array[i++] = 0;
        }
        return array;
    }
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
