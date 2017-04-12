/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if (root == null) {
            return root;
        }
        if (root.val == value) {
            return adjust(root, value);
        } else if (root.val > value) {
            return root.left = removeNode(root.left, value);
        } else {
            return root.right = removeNode(root.right, value);
        }
    }
    private TreeNode adjust(TreeNode root, int value) {
        TreeNode pre = root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        while (left != null && left.right != null) {
            pre = left;
            left = left.right;
        }
        if (left != null) {
            moveToRoot(root, pre, left);
            return left;
        }
        while (right != null && right.left != null) {
            pre = right;
            right = right.left;
        }
        if (right != null) {
            moveToRoot(root, pre, right);
            return right;
        }
        return null;
    }
    private void moveToRoot(TreeNode root, TreeNode pre, TreeNode cur) {
        pre.right = null;
        cur.left = root.left;
        cur.right = root.right;
        root.left = null;
        root.right = null;
    }
}
