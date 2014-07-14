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
    public ListNode mergeKLists(List<ListNode> lists) {
		if(lists == null || lists.length == 0) return null;
		return helper(lists, 0, lists.size()-1);
    }
	public ListNode helper(List<ListNode> lists, int l, int r) {
		if(l >= r) return lists.get(l);
		int m = (l + r) / 2;
		return merge(helper(lists, l, m), helper(lists, m+1, r));
	}
	public ListNode merge(ListNode l1, ListNode l2) {
		ListNode fake = new ListNode(-1);
		fake.next = l1;
		ListNode curr = fake;
		while(curr.next != null && l2 != null) {
			if(curr.next.val > l2.val) {
				ListNode tmp = curr.next;
				curr.next = l2;
				l2 = l2.next;
				curr.next.next = tmp;
			}
			curr = curr.next;
		}
		if(l2 != null) curr.next = l2;
		return curr;
	}
}
