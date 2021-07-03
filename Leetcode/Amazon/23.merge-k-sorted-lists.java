/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (ListNode n : lists) {
            if (n != null) {
                minHeap.offer(n);
            }    
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (!minHeap.isEmpty()) {
            ListNode temp = minHeap.poll();
            curr.next = temp;
            curr = curr.next;
            if (temp.next != null) {
                minHeap.offer(temp.next);
            }
        }
        return dummy.next;
    }
}
// @lc code=end

