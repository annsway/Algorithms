package QueueAndStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SortingByTwoStacks {
    public static void main(String[] args) {
//        LinkedList<Integer> s1 = new LinkedList<>();
//        s1.push(2);
//        s1.push(1);
//        s1.push(3);
//        s1.push(3);
//        sort(s1);
//        System.out.println(s1.peek());
//        System.out.println(s1);
        // test
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerFirst(1);
        stack.offerFirst(2);
        stack.offerFirst(3);

        System.out.println("After offerFirst(): " + stack);

        stack.pollFirst();
        System.out.println("After pollFirst(): " + stack);

        System.out.println("PeekFirst(): " + stack.peekFirst());
    }

    public static void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        if (s1 == null) {
            return;
        }
        sort(s1, s2);
    }

    public static void sort(LinkedList<Integer> s1, LinkedList<Integer> s2) {
        while (!s1.isEmpty()) {
            int min = Integer.MAX_VALUE;
            int count = 0;
            // find the current min in s1
            while (!s1.isEmpty()) {
                int cur = s1.pop();
                s2.push(cur);
                if (cur == min) {
                    count++;
                } else if (cur < min) {
                    min = cur;
                    count = 1;
                }
            }
            // put back to s1
            while (!s2.isEmpty()) {
                if (s2.peek() > min) {
                    s1.push(s2.pop());
                } else if (s2.peek() == min) {
                    s2.pop();
                } else {
                    break;
                }
            }
            // put min to s2
            while (count != 0) {
                s2.push(min);
                count--;
            }
            // repeat
        }
        // put the sorted array back to s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }



}

