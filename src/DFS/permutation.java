package DFS;

import java.util.ArrayList;
import java.util.List;

public class permutation{
    public List<String> permutation(String input){
        List<String> res = new ArrayList<>();
        char[] data = input.toCharArray();
        helper(data, 0, res);
        return res;
    }
    private void helper(char[] input, int index, List<String> res){
        if (index == input.length) {
            res.add(new String(input));
            return;
        }

        for(int i = index; i < input.length; i++) {
            swap(input, i, index);
            helper(input, index + 1, res);
            swap(input, i, index);
        }
    }
    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        permutation sol = new permutation();
       String input = "abc";
        System.out.println(sol.permutation(input));
    }
}