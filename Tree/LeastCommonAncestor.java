
public class LeastCommonAncestor {
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || root == node1 || root == node2) {
            return root;
        }

        // Divide
        TreeNode left = lowestCommonAncestor(root.left, node1, node2);
        TreeNode right = lowestCommonAncestor(root.right, node1, node2);

        // Conquer

        // the only way this can happen is that left and right both have root as common ancester
        if (left != null && right != null) {
            return root;
        }

        // only left is not null but right is null meaning that nodes have LCA of left
        if (left != null) {
            return left;
        }

        // vice versa
        if (right != null) {
            return right;
        }
        // last case both are null then it is a leaf
        return null;
    }

}
