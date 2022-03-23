package OOP;

import java.util.Arrays;

public class Override2DcharArray {
    public static void main(String[] args) {
        char[][] array = {{'a', 'b'}, {'c', 'd'}};
        System.out.println(Arrays.deepToString(array));
        array[0][0] = 't';
    }
}
