public class Solution {  
	TreeNode p = null;
	TreeNode a = null;
	TreeNode b = null;
    public void recoverTree(TreeNode root) {  
		if(root == null) return;
		helper(root);
		int tmp = a.val;
		a.val = b.val;
		b.val = tmp;
    }  
    public void helper(TreeNode root) {
		if(root == null) return;
		helper(root.left);
		if(p != null && p.val > root.val) {
			if(a == null) {
				a = p;
				b = root;
			} else b = root;
		}
		p = root;
		helper(root.right);
	}
}  
