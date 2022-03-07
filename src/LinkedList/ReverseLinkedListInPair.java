package LinkedList;

public class ReverseLinkedListInPair {
    public ListNode reverseInPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode third = head.next.next;
        ListNode newHead = head.next;
        head.next.next = head;
        head.next = reverseInPairs(third);
        return newHead;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        ListNode head = SolLinkedList.createLinkedList(arr);

        ReverseLinkedListInPair sol = new ReverseLinkedListInPair();
        ListNode reversedHead = sol.reverseInPairs(head);
        System.out.println(reversedHead);
    }
}
