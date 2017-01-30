public class KthSmallestBST {
    public int kthSmallest(TreeNode root, int k) {
        int countLeftSubTree = countNodes(root.left);

        if (k <= countLeftSubTree) {
            return kthSmallest(root.left, k);
        } else if (k > countLeftSubTree + 1) {
            return kthSmallest(root.right, k - 1 - countLeftSubTree); // 1 is counted as current node
        }

        return root.val;
    }

    public int countNodes(TreeNode n) {
        if (n == null) {
            return 0;
        }

        return 1 + countNodes(n.left) + countNodes(n.right);
    }
}