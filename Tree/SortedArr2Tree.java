
public class SortedArr2Tree {
    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        Node root = arr2BST(arr);

        inOrder(root);
    }

    public static void inOrder(Node cur) {
        if (cur != null) {
            inOrder(cur.left);
            System.out.println(cur.val);
            inOrder(cur.right);
        }
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
