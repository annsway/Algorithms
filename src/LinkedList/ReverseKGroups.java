package LinkedList;

import static LinkedList.SolLinkedList.createLinkedList;

public class ReverseKGroups {
    /**
     * 1 -> 2 -> 3 -> 4 -> null
     * h
     * TC: O(n)
     * SC: O(n)
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0; // count the number of elements traversed in the k group
        while (cur != null && count != k) { // find the k+1-th node
            cur = cur.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            ListNode reversedHead = reverseKGroup(cur, k);
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in original part
                head.next = reversedHead; // previous head must point to the reversed head
                reversedHead = head; // update reversedHead with the previous head
                head = tmp; // update head with the next element in the original part
            }
            head = reversedHead;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = createLinkedList(arr);
        ListNode newHead = reverseKGroup(head, 2);
    }
}
