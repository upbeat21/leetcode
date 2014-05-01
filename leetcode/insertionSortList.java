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
	
    public static ListNode insertionSortList(ListNode head) {
    	if(head == null || head.next == null) return head;
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		ListNode curr1 = dummyHead;
		ListNode sortedList = new ListNode(-1);
		while(curr1.next != null) {
			ListNode curr2 = sortedList;
			ListNode tmp = curr1.next;
			while(curr2.next != null && curr2.next.val < tmp.val) {
				curr2 = curr2.next;
			}
			ListNode tmp2 = curr2.next;
			curr2.next = new ListNode(tmp.val);
			curr2.next.next = tmp2;
			curr1 = curr1.next;
		}
		return sortedList.next;
    }
    public static void main(String[] args) {
    	ListNode head = new ListNode(3);
    	head.next = new ListNode(4);
    	head.next.next = new ListNode(1);
    	System.out.println(head.toString());
    	insertionSortList(head);
    }
}