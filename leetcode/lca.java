public Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        public TreeNode(int v) {
            val = v;
            left = null;
            right = null;
            parent = null;
        }
    }
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if(left != null || right != null) return root;
        return left != null ? left : right;
    }
    public TreeNode lca2(TreeNode root, TreeNode p, TreeNode q) {
        int pH = 0;
        int qH = 0;
        TreeNode tmp = p;
        while(tmp != root) {
            tmp = tmp.parent;
            pH++;
        }
        tmp = q;
        while(tmp != root) {
            tmp = tmp.parent;
            qH++;
        }
        while(pH > qH) p = p.parent;
        while(qH > pH) q = q.parent;
        while(p != q && p != null) {
            p = p.parent;
            q = q.parent;
        }
        return p;
    }
}
