package problem124;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max_sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return max_sum;
    }

    public int maxPathSumHelper(TreeNode root) {
        if(root == null) return 0;

        int leftVal = Math.max(maxPathSumHelper(root.left), 0);
        int rightVal = Math.max(maxPathSumHelper(root.right), 0);
        max_sum = Math.max(max_sum, root.val + leftVal + rightVal);
        return root.val + Math.max(leftVal, rightVal);
    }

}