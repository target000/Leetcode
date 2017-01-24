import java.util.ArrayList;
import java.util.List;

public class BinaryTreeAllPath {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if (root != null)
            searchBT(root, "", answer);
        return answer;
    }

    // three cases are considered
    // 1) both descendent are null
    // 2) left is not null
    // 3) right is not null
    private void searchBT(TreeNode cur, String path, List<String> answer) {
        if (cur.left == null && cur.right == null)
            answer.add(path + cur.val);
        if (cur.left != null)
            searchBT(cur.left, path + cur.val + "->", answer);
        if (cur.right != null)
            searchBT(cur.right, path + cur.val + "->", answer);
    }

}
