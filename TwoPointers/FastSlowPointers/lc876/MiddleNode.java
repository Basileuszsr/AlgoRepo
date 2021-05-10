// public class ListNode {
//     ListNode next;
//     int val;
//     public ListNode (int val, ListNode next) {
//         this.val = val;
//         this.next = next;
//     }
// }


public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        if (head == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
