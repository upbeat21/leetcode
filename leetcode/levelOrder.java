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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null) return list;
        List<TreeNode> m = new ArrayList<TreeNode>();
        m.add(root);
        while(!m.isEmpty()) {
            List<TreeNode> n = new ArrayList<TreeNode>();
            List<Integer> p = new ArrayList<Integer>();
            for(int i=0;i<m.size();i++) {
                TreeNode node = m.get(i);
                p.add(node.val);
                if(node.left != null) n.add(node.left);
                if(node.right != null) n.add(node.right);
            }
            list.add(p);
            m = n;
        }
        return list;
    }
}
