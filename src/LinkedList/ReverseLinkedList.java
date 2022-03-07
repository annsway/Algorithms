package LinkedList;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
//        newHead.next = head; // WRONG!
        head.next = null;
        return newHead;
    }
    public static void main(String[] args) {
        ReverseLinkedList sol = new ReverseLinkedList();
        SolLinkedList list = new SolLinkedList();
        int[] arr = {1,2,3};
        ListNode head = list.createLinkedList(arr);
        System.out.println(sol.reverseList(head).value);
    }
}
