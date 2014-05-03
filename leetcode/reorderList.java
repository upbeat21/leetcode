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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
		ListNode mid = getMidNode(head);
		ListNode sHalf = mid.next;
		mid.next = null;
		ListNode _sHalf = reverse(sHalf);
		int k = 0;
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		ListNode curr = dummyHead;
		while(_sHalf != null && head != null) {
			if(k % 2 == 0) {
				curr.next = head;
				head = head.next;
			} else {
				curr.next = _sHalf;
				_sHalf = _sHalf.next;
			}
			k++;
			curr = curr.next;
		}
		if(k % 2 == 0 && head != null) curr.next = head;
		else if(k % 1 == 0 && _sHalf != null) curr.next = _sHalf;
		head = dummyHead.next;
    }
	public ListNode getMidNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	public ListNode reverse(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode a = head;
		ListNode b = head.next;
		head.next = null;
		do {
			ListNode c = b.next;
			b.next = a;
			a = b;
			b = c;
		} while(b != null);
		return a;
	}
}