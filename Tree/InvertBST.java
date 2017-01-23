public class InvertBST {
    public TreeNode invertTree(TreeNode root) {

        // as a convention always handle the edge/speical case first
        if (root == null) {
            return null;
        }

        // this temp is needed due to that root.left will be overwritten

        TreeNode temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;

        return root;

    }
}