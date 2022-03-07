package QueueAndStack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueVsStack {
    public static void main(String[] args) {
        // queue
        Queue<Integer> q1 = new LinkedList<>();

        q1.offer(1); // insert an element in the tail of the queue
        q1.offer(2);
        q1.offer(3);

        q1.poll(); // get an element from the head of the queue

        System.out.println(q1.peek());// read the value of the head element of the queue

        // stack
        Deque<Integer> s1 =  new LinkedList<>();

        s1.offerFirst(1); //insert an element in the top of the stack
        s1.offerFirst(2);
        s1.offerFirst(3);

        s1.pollFirst(); // get an element from the top of the stack
        System.out.println(s1.peekFirst()); // read the value of top element in stack

    }
}
