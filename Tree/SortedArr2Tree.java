import java.util.ArrayList;
import java.util.List;

public class SortedArr2Tree {
    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        Node root = arr2BST(arr);

        int res = findSuccessor(root, 7);
        System.out.println(res);
    }

    public static void inOrderTraversal(Node cur) {
        if (cur != null) {
            inOrderTraversal(cur.left);
            System.out.println(cur.val);
            inOrderTraversal(cur.right);
        }
    }

    public static void inOrderTraversal2(Node cur, List<Integer> list, int i, int val) {
        if (cur != null && i <= 1) {
            inOrderTraversal2(cur.left, list, i, val);
            list.add(cur.val);
            if (cur.val == val) {
                i++;
            }
            inOrderTraversal2(cur.right, list, i, val);
        }
    }

    public static int findSuccessor(Node cur, int val) {
        List<Integer> list = new ArrayList<>();

        inOrderTraversal2(cur, list, 0, val);

        int index = list.indexOf(val) + 1;
        return (index < list.size() - 1) ? (int) list.get(index) : -1;
    }

    // preorder

    // postorder

    public static Node sortedArr2BST(int[] arr, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = low + (high - low) / 2;

        Node n = new Node(arr[mid]);

        n.left = sortedArr2BST(arr, low, mid - 1);
        n.right = sortedArr2BST(arr, mid + 1, high);

        return n;

    }

    public static Node arr2BST(int[] arr) {
        return sortedArr2BST(arr, 0, arr.length - 1);
    }

}
