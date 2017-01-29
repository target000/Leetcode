import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversalIterative {
    // InOrder traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

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

    // PostOrder
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if (temp.left == null && temp.right == null) {
                TreeNode pop = stack.pop();
                res.add(pop.val);
            } else {
                if (temp.right != null) {
                    stack.push(temp.right);
                    temp.right = null;
                }

                if (temp.left != null) {
                    stack.push(temp.left);
                    temp.left = null;
                }
            }
        }

        return res;
    }

}

// Preorder
class BinaryTree {

    Node root;

    void iterativePreorder() {
        iterativePreorder(root);
    }

    // An iterative process to print preorder traversal of Binary tree
    void iterativePreorder(Node node) {

        // Base Case
        if (node == null) {
            return;
        }

        // Create an empty stack and push root to it
        Stack<Node> nodeStack = new Stack<Node>();
        nodeStack.push(root);

        /*
         * Pop all items one by one. Do following for every popped item a) print it b) push its right child c) push its left child Note that right child is pushed first so that left is processed first
         */
        while (nodeStack.empty() == false) {

            // Pop the top item from stack and print it
            Node mynode = nodeStack.peek();
            System.out.print(mynode.data + " ");
            nodeStack.pop();

            // Push right and left children of the popped node to stack
            if (mynode.right != null) {
                nodeStack.push(mynode.right);
            }
            if (mynode.left != null) {
                nodeStack.push(mynode.left);
            }
        }
    }
}
