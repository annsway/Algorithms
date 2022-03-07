package Recursion;// Problem: find the smallest k integer numbers in an unsorted array with size n.

public class Power {
    public long power(int a, int b) {
        // Write your solution here
        if(a == 0 || b == 0){
            return 1;
        }
        long half = power(a, b/2);
        if(b % 2 == 0){
            return half*half;
        } else {
            return half*half*a;
        }
    }


//    private void swap(int[] array, int i, int j){
//        int temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
//    }

    public static void main(String[] args) {
        Power solution = new Power();
        int[] arr = {5, 1, 0, 2, 3};

        System.out.println(solution.power(2, 3));
    }
}



