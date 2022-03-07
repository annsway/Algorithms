package QueueAndStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class SolStacks {

    static Deque<Integer> s1;
    static Deque<Integer> s2; // maintains the min values so far
    static Deque<Integer> s3; // maintains the size of s1 and at which the min value is
    static int size;

    public SolStacks() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
        s3 = new ArrayDeque<>();
    }

    public static int pop() {
        if (s1.isEmpty()) {
            return -1;
        }
        int cur = s1.peekFirst();
        if (!s2.isEmpty() && cur == s2.peekFirst() && s3.peekFirst() == size) {
            s2.pollFirst();
            s3.pollFirst();
        }
        if (size > 0) {
            size--;
        }
        return s1.pollFirst();
    }

    public static void push(int element) {
        s1.offerFirst(element);
        size++;
        if (s2.isEmpty() || element < s2.peekFirst()) {
            s2.offerFirst(element);
            s3.offerFirst(size);
        }
    }

    public static int top() {
        return s1.isEmpty() ? -1 : s1.peekFirst();
    }

    public static int min() {
        return s2.isEmpty() ? -1 : s2.peekFirst();
    }

    public static void main(String[] args) {
        SolStacks stack = new SolStacks();
        push(3);
        push(2);
        push(3);
        push(1);
        push(5);

        System.out.println(min());

        pop();
        pop();
        pop();
        pop();
        pop();
        pop();

        System.out.println(min());

    }
}
