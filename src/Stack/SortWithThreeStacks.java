package Stack;

import java.util.LinkedList;

public class SortWithThreeStacks {
    public void sort(LinkedList<Integer> input) {
        LinkedList<Integer> buffer = new LinkedList<Integer>();
        LinkedList<Integer> result = new LinkedList<Integer>();
        Integer curMin = Integer.MAX_VALUE;
        int size = input.size();
        while (result.size() != size) {
            while (!input.isEmpty()) {
                Integer cur = input.pop();
                if (cur < curMin) {
                    curMin = cur;
                }
                buffer.push(cur);
            }
            while (!buffer.isEmpty()) {
                if (!buffer.peek().equals(curMin)) {
                    input.push(buffer.pop());
                } else {
                    buffer.pop();
                    result.push(curMin);
                }
            }
            curMin = Integer.MAX_VALUE;
        }
        while (!result.isEmpty()) {
            input.push(result.pop());
        }
        System.out.println(input);
    }

    public static void main(String[] args) {
        SortWithThreeStacks sol = new SortWithThreeStacks();
        LinkedList<Integer> input = new LinkedList<Integer>();
        // 5, 3, 1, 4
        input.push(5);
        input.push(3);
        input.push(1);
        input.push(3);
        sol.sort(input);
//        System.out.println(input);
    }
}
// TC: O(n^2)
// SC: O(1) // assume the three stacks are given

