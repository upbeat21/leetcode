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
	public int r = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
		helper(root, root.val);
		return r;
    }
	public void helper(TreeNode root, int n) {
		if(root.left == null && root.right == null) {
			r += n;
			return;
		}
		if(root.left != null)
			helper(root.left, n * 10 + root.left.val);
		if(root.right != null)
			helper(root.right, n * 10 + root.right.val);
	}
}
