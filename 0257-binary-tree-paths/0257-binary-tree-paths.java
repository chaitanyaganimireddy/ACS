
import java.util.*;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        findPaths(root, "", result);
        return result;
    }

    public void findPaths(TreeNode root, String path,
                          List<String> result) {
        if (root == null) {
            return;
        }

        if (path.isEmpty()) {
            path = "" + root.val;
        } else {
            path += "->" + root.val;
        }

        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        findPaths(root.left, path, result);
        findPaths(root.right, path, result);
    }
}
