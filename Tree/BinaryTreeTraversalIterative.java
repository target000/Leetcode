import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeTraversalIterative {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> list = new ArrayList<Integer>();

        if (root == null)
            return list;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        // define a pointer to track nodes
        TreeNode p = root;

        while (!stack.empty() || p != null) {

            // if it is not null, push to stack
            // and go down the tree to left
            if (p != null) {
                stack.push(p);
                p = p.left;

                // if no left child
                // pop stack, process the node
                // then let p point to the right
            } else {
                TreeNode t = stack.pop();
                list.add(t.val);
                p = t.right;
            }
        }

        return list;
    }
}