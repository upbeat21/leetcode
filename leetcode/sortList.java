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
    public ListNode sortList(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode mid = getMidNode(head);
		ListNode half = mid.next;
		mid.next = null;
		return merge(sortList(head), sortList(half));
    }
	public ListNode merge(ListNode a, ListNode b) {
		ListNode dummyHead = new ListNode(-1);
		ListNode curr = dummyHead;
		while(a != null && b != null) {
			if(a.val <= b.val) {
				curr.next = a;
				a = a.next;
			} else {
				curr.next = b;
				b = b.next;
			}
			curr = curr.next;
		}
		curr.next = (a == null) ? b : a;
		return dummyHead.next;
	}
	public ListNode getMidNode(ListNode head) {
		if(head == null) return head;
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
}