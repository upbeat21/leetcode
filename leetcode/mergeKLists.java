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
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(10, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode l1, ListNode l2) {
				return l1.val - l2.val;
			}
		});
		for(int i=0;i<lists.size();i++) {
			ListNode node = lists.get(i);
			if(node != null) heap.offer(node);
		}
		ListNode fake = new ListNode(-1);
		ListNode curr = fake;
		while(!heap.isEmpty()) {
			ListNode node = heap.poll();
			curr.next = node;
			if(node.next != null) heap.offer(node.next);
			curr = curr.next;
		}
		return fake.next;
    }
}
