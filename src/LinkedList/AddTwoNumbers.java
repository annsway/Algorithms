package LinkedList;

public class AddTwoNumbers {
    public static ListNode sumTwoNumbers(ListNode one, ListNode two) {
        // Write your solution here
        int sum = 0;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(one != null || two != null || sum != 0){
            if(one != null){
                sum += one.value;
                one = one.next;
            }
            if(two != null){
                sum += two.value;
                two = two.next;
            }
            curr.next = new ListNode(sum % 10); // 记录个位数
            sum = sum / 10; // carry 保留十位数
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        SolLinkedList list = new SolLinkedList();

        int[] a1 = {9, 9};
        int[] a2 = {9, 9, 1, 2, 3, 5};
        ListNode one = list.createLinkedList(a1);
        ListNode two = list.createLinkedList(a2);
        sumTwoNumbers(one, two);

    }
}
