package LinkedList;

public class SolLinkedList {
    public static ListNode createLinkedList(int[] array){
        ListNode head = new ListNode(array[0]);
        ListNode curr = head;
        for(int i=1; i<array.length; i++){
            curr.next = new ListNode(array[i]);
            curr = curr.next;
        }
        return head;
    }

//    public LinkedList.ListNode appendTail(){
//
//    }

    public ListNode get(ListNode head, int index){
        // Termination condition 取反 De Morgan‘s Laws
        // Corner cases: index <= 0 || head == null
        while(index > 0 && head != null){
            head = head.next;
            index--;
        }
        return head;
    }

//    LinkedList.ListNode get(LinkedList.ListNode head, int target){
//        if(head == null){
//            return null;
//        }
//        int count = 0;
//
//        LinkedList.ListNode curr = head;  // you don't have to create
//        while(curr != null){
//            if(count == target){
//                return curr;
//            }
//            curr = curr.next;
//            count++;
//        }
//        return null;
//    }


    public ListNode reverse(ListNode head) {
        // Base case
        if (head == null || head.next == null) {
            return null;
        }
        // Sub-problem
        ListNode reversedHead = reverse(head.next);
        ListNode cur = head.next;
        cur.next = head; // head is "prev"
        head.next = null;
        return reversedHead;
    }
    /*
  1 -> 2 -> 3 -> null
           cur
     prev
L0 head = , cur = , head(prev) = 1
--------------------------
L1 head = , cur = , head(prev) = 2
--------------------------
L2 prev = 2, cur = 3, head(prev) = 3

reverseHead = 3
*/
    public static void main(String[] args) {
        SolLinkedList sol = new SolLinkedList();
        int[] arr1 = {1, 2, 3};
        ListNode head1 = sol.createLinkedList(arr1);
//        LinkedList.ListNode node = sol.get(head, 1);
//        System.out.println(node.value);

        System.out.println(sol.reverse(head1).value);

    }

}
