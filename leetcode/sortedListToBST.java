/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        this.head = head;
        int len = getLen(head);
        return sortedListToBST(0, len - 1);
    }
    public TreeNode sortedListToBST(int start, int end) {
        if(start > end) return null;
        int mid = (start + end) / 2;
        TreeNode left = sortedListToBST(start, mid-1);
        TreeNode root = new TreeNode(head.val);
        root.left = left;
        head = head.next;
        root.right = sortedListToBST(mid+1, end);
        return root;
    }
    public int getLen(ListNode head) {
        ListNode p = head;
        int len = 0;
        while(p != null) {
            p = p.next;
            len++;
        }
        return len;
    }
}
