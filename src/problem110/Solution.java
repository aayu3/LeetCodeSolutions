package problem110;

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
class Solution
{
    public boolean isBalanced(TreeNode root)
    {

        if(root == null)
        {
            return true;
        }

        int leftH = height(root.left), rightH = height(root.right);
        if (Math.abs(leftH - rightH) > 1)
        {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root)
    {

        if(root == null)
        {
            return 0;
        }

        int leftHeight = height(root.left) + 1;
        int rightHeight =  height(root.right) + 1;

        return Math.max(leftHeight, rightHeight);
    }
}