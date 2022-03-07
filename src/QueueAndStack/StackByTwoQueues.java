package QueueAndStack;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackByTwoQueues {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    StackByTwoQueues(){
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {
        Integer prev = q1.poll();
        Integer curr = q1.poll();
        while (curr != null) {
            q2.offer(prev); // 最后一个prev不会进入q2
            prev = curr;
            curr = q1.poll();
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return prev;
    }

    /** Get the top element. */
    public Integer top() {
        if (q1 == null) {
            return null;
        }
        int ret = pop();
        q1.offer(ret);
        return ret;
    }

    /** Returns whether the stack is empty. */
    public boolean isEmpty() {
        return top() == null;
    }

    public static void main(String[] args) {
        StackByTwoQueues q = new StackByTwoQueues();

//        q.push(2);
//        q.push(3);
//        q.push(0);
//        q.push(0);
//        q.push(5);

//        System.out.println(q.pop());
////        System.out.println(q.pop());
////        System.out.println(q.pop());
////
//        System.out.println(q.top());
//        System.out.println(q.isEmpty());
        System.out.println(q.q1);
    }
}
