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
	int max = 0;
    public int maxPathSum(TreeNode root) {
		if(root == null) return 0;
		max = root.val;
		findMax(root);
		return max;
    }
	public int findMax(TreeNode root) {
		if(root == null) return 0;
		int left = Math.max(findMax(root.left), 0);
		int right = Math.max(findMax(root.right), 0);
		max = Math.max(max, left + right + root.val);
		return Math.max(left, right) + root.val;
	}
}
