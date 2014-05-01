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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
		if(root == null) return result;
		TreeNode curr = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode lastVisited = null;
		stack.push(root);
		while(!stack.isEmpty()) {
			curr = stack.peek();
			if(lastVisited == null || lastVisited.left == curr || lastVisited.right == curr) {
				if(curr.left != null) stack.push(curr.left);
				else {
					if(curr.right != null) stack.push(curr.right);
					else {
						result.add(curr.val);
						stack.pop();
					}
				}
			} else if(curr.left == lastVisited) {
				if(curr.right != null) stack.push(curr.right);
				else {
					result.add(curr.val);
					stack.pop();
				}
			} else if(curr.right == lastVisited) {
				result.add(curr.val);
				stack.pop();
			}
			lastVisited = curr;
		}
		return result;
    }
}