package problem99;

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
    TreeNode pre, first, second;
    public void recoverTree(TreeNode root) {
        dfs(root);
        swap(first, second);

    }
    //inorder
    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);

        if(pre != null && root.val <= pre.val) {
            if(first == null) first = pre;     //notice here
            second = root;
        }
        pre = root;

        dfs(root.right);
    }

    public void swap(TreeNode node1, TreeNode node2){
        if(node1 != null && node2 != null){
            int tmp = node1.val;
            node1.val = node2.val;
            node2.val = tmp;
        }
    }
}