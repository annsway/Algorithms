package OOP;

import java.util.Arrays;

public class InterfaceTopic {
    public static void main(String[] args) {
        /*The wrapper classes have already implemented the Comparable interface */
        Integer[] array = {100, 1, -90, 88, 4};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
