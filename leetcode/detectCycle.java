/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return null;
		ListNode slow = head;
		ListNode fast = head;
		while(true) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) break;
			if(fast.next == null || fast.next.next == null)  return null;
		}
		slow = head.next;
		fast = head.next.next;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next.next;
		}
		slow = head;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
    }
}