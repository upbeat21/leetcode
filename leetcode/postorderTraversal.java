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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
		if(root == null) return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode lastVisited = null;
		while(!stack.isEmpty()) {
			TreeNode curr = stack.peek();
			if(lastVisited == null || lastVisited.left == curr || lastVisited.right == curr) {
				if(curr.left != null) stack.push(curr.left);
				else if(curr.right != null) stack.push(curr.right);
				else list.add(stack.pop().val);
			} else if(curr.left == lastVisited) {
				if(curr.right != null) stack.push(curr.right);
				else list.add(stack.pop().val);
			} else if(curr.right == lastVisited) {
				list.add(stack.pop().val);
			}
			lastVisited = curr;
		}
		return list;
    }
	
}
