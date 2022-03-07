package QueueAndStack; /**
 * Implement a queue by using two stacks.
 * **/

import java.util.Deque;
import java.util.LinkedList;

public class QueueByTwoStack {
    Deque<Integer> in;
    Deque<Integer> out;

    // Constructor: to create two stacks
    public QueueByTwoStack(){
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    // Note: anything 'in' or 'out' stack calls, it's calling the method of stack API
    //      e.g. offerFirst(value), peekFirst(), pollFirst()
    //      they are applied to the top element of a stack

    // When calling either poll() or peek(), move all the elements from stack 'in'
    // to stack 'out' so that the 'queue' will be in the reversed order
    // Only needs to move once.
    private void move(){
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.offerFirst(in.pollFirst());
            }
        }
    }

    public Integer poll(){
        move();
        return out.isEmpty() ? null : out.pollFirst();
    }
    public void offer(int value){
        in.offerFirst(value);
    }
    public Integer peek(){
        move();
        return out.isEmpty() ? null : out.peekFirst();
    }

    public static void main(String[] args) {
        QueueByTwoStack queue = new QueueByTwoStack();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        queue.peek();
        queue.poll();

        queue.offer(99); // 99 won't be added to the queue 'out' till every element in 'out' gets poll()
        // at this moment, both 'in' and 'out' are NOT empty, which doesn't matter because
        // neither peek() or poll() methods of the queue would touch the LAST element added, which is 99

        queue.poll();
        queue.poll();

        System.out.println(queue.peek());

    }
}
