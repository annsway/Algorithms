package LinkedList;

import static LinkedList.SolLinkedList.createLinkedList;

public class MergeLinkedList {
    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode node = mid.next;
        mid.next = null;
        ListNode one = mergeSort(head);
        ListNode two = mergeSort(node);
        return merge(one, two);
    }
    private ListNode findMid(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (one != null && two != null) {
            if (one.value < two.value) {
                cur.next = one;
                one = one.next;
            } else {
                cur.next = two;
                two = two.next;
            }
            cur = cur.next;
        }
        if (one != null) {
            cur.next = one;
        }
        if (two != null) {
            cur.next = two;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        MergeLinkedList sol = new MergeLinkedList();
//        int[] arr = {4, 2, 6, -3, 5};
        int[] arr = {1, 2, 3};
        ListNode head = createLinkedList(arr);
        ListNode newHead = sol.mergeSort(head);
        System.out.println(newHead);
    }
}
