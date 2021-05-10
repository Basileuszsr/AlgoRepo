// public class ListNode {
//     ListNode next;
//     int val;
//     public ListNode (int val, ListNode next) {
//         this.val = val;
//         this.next = next;
//     }
// }


public class CircleList {
    public boolean circleList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
