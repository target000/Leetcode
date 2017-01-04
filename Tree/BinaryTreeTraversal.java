import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeTraversal {

    // Definition for binary tree
    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5 };
        TreeNode n = arr2BST(arr);

        List<Integer> list = inOrderTraversal(n);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }

    }

    public static List<Integer> inOrderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        List<Integer> list = new ArrayList<Integer>();

        if (root == null)
            return list;

        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        // define a pointer to track nodes
        TreeNode cur = root;

        while (!stack.isEmpty() || cur != null) {

            // if it is not null, push to stack
            // and go down the tree to left
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;

                // if no left child
                // pop stack, process the node
                // then let p point to the right
            } else {
                TreeNode pop = stack.pop();
                list.add(pop.val);
                cur = pop.right;
            }
        }

        return list;
    }

    public static TreeNode sortedArr2BST(int[] arr, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = low + (high - low) / 2;

        TreeNode n = new TreeNode(arr[mid]);

        n.left = sortedArr2BST(arr, low, mid - 1);
        n.right = sortedArr2BST(arr, mid + 1, high);

        return n;

    }

    public static TreeNode arr2BST(int[] arr) {
        return sortedArr2BST(arr, 0, arr.length - 1);
    }

}
