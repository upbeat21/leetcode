/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
		ListNode fake = new ListNode(-1);
		ListNode curr = fake;
		ListNode loop = head;
		boolean stop = false;
		while(loop != null) {
			ListNode c = loop;
			for(int i=0;i<k-1;i++) {
				c = c.next;
				if(c == null) {
					curr.next = loop;
					stop = true;
					break;
				}
			}
			if(stop) break;
			for(int i=0;i<k;i++) {
				ListNode next = loop.next;
				ListNode tmp = curr.next;
				curr.next = loop;
				loop.next = tmp;
				loop = next;
			}
			for(int i=0;i<k;i++) curr = curr.next;
		}
		return fake.next;
    }
}
