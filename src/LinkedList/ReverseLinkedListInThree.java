package LinkedList;

import static LinkedList.SolLinkedList.createLinkedList;

public class ReverseLinkedListInThree {
/**  1 -> 2 -> 3 -> 4 -> null
               h
     TC: O(n)
     SC: O(n)
 */
    public static ListNode reverseInThree(ListNode head) {
        // base case
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode n2 = head.next;
        ListNode n3 = head.next.next;
        ListNode reversedHead = reverseInThree(n3.next);
        // reverse
        n3.next = n2;
        n2.next = head;
        head.next = reversedHead;
        return n3;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        ListNode head = createLinkedList(arr);
        ListNode newHead = reverseInThree(head);
    }
}
