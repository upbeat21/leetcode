public class Solution {
	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			val = val;
			next = null;
		}
	}
	public void IIDOTIII(ListNode head) {
		if(head == null) return null;
		ListNode fake = new ListNode(-1);
		fake.next = head;
		ListNode slow = fake;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		if(slow.next != null)
			slow.next = slow.next.next;
	}
	
}
