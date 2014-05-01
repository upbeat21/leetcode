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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
		if(root == null) return result;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode curr;
		stack.push(root);
		TreeNode lastVisited = null;
		while(!stack.isEmpty()) {
			curr = stack.peek();
			if(lastVisited == null || lastVisited.left == curr || lastVisited.right == curr) {
				result.add(curr.val);
				if(curr.left != null) {
					stack.push(curr.left);
				} else {
					if(curr.right != null) {
						stack.push(curr.right);
					} else {
						stack.pop();
					}
				}
			} else if(lastVisited == curr.left) {
				if(curr.right != null) stack.push(curr.right);
				else stack.pop();
			} else if(lastVisited == curr.right) {
				stack.pop();
			}
			lastVisited = curr;
		}
		return result;
    }
}