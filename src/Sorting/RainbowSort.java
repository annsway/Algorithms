package Sorting;

import java.util.Arrays;

public class RainbowSort {
//
//    public int[] rainbowSortIII(int[] array, int k) {
//        if(array == null || array.length == 1){
//            return array;
//        }
//
//        int[] pointers = new int[k];
//
//        while(pointers[k - 1] < array.length){
//            int value = array[pointers[k - 1]];
//            for(int i = 1; i <= k - value; i++){
//                swap(array, pointers[k - i], pointers[k - i - 1]);
//            }
//            for(int i = 1; i <= k - value + 1; i++){
//                pointers[k - i]++;
//            }
//        }
//        return array;
//    }

    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int[] rainbowSortIII(int[] array, int k) {
        // Write your solution here
        if (array == null || array.length == 0){
            return array;
        }
        int[] pointers = new int[k+1];
        pointers[k] = array.length - 1;
        while(pointers[k-1] <= pointers[k]){
            int cur = array[pointers[k-1]];
            if(cur < k-1){
                for(int i = k-1; i > cur; i--){
                    swap(array,pointers[i]++,pointers[i-1]);
                }
                pointers[cur]++;
            } else if (cur == k-1){
                pointers[k-1]++;
            } else if (cur == k){
                swap(array,pointers[k-1],pointers[k]--);
            }
        }
        return array;
    }

    public static void main(String[] args) {
        RainbowSort rs = new RainbowSort();
        int[] arr = {3, 1, 1, 4, 2};
        System.out.println(Arrays.toString(rs.rainbowSortIII(arr, 4)));
    }

}
