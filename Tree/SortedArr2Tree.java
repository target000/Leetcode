
public class SortedArr2Tree {
    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        Node root = sortedArr2BST(arr, 0, arr.length - 1);

        inOrderTraversal(root);
    }

    // it is actually not that intutitive
    public static void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.val);
            inOrderTraversal(root.right);
        }
    }

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

}
