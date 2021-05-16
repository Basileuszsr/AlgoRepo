class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode current = head, previous = null;
        for (int i = 0; current != null && i < left - 1; i++) {
            previous = current;
            current = current.next;
        }
        ListNode lastNodeOfFirstPart = previous;
        ListNode lastNodeOfSubList = current;
        ListNode next = null;
        for (int i = 0; current != null && i < right - left + 1; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        if (lastNodeOfFirstPart != null) {
            lastNodeOfFirstPart.next = previous;
        } else {
            head = previous;
        }
        lastNodeOfSubList.next = current;
        return head;
    }
}
