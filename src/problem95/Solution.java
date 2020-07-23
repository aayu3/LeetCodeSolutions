package problem95;

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

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] dp = new ArrayList[n+1];
        if (n >= 0) {
            dp[0] = new ArrayList<TreeNode>();
        }
        if (n >= 1) {
            dp[1] = new ArrayList<TreeNode>();
            dp[1].add(new TreeNode(1));
        }
        if (n >= 2) {
            for (int i = 2; i <= n; i++) {
                dp[i] = new ArrayList<TreeNode>();
                for (int j = 1; j <= i; j++) {
                    List<TreeNode> leftTreeList = dp[j-1];
                    List<TreeNode> rightTreeList = dp[i-j];
                    if (!leftTreeList.isEmpty() && !rightTreeList.isEmpty()) {
                        for (TreeNode leftTree : leftTreeList) {
                            for (TreeNode rightTree : rightTreeList) {
                                TreeNode newNode = new TreeNode(j);
                                newNode.left = copyTree(leftTree, 0);
                                newNode.right = copyTree(rightTree, j);
                                dp[i].add(newNode);
                            }
                        }
                    } else if (!leftTreeList.isEmpty()) {
                        for (TreeNode leftTree : leftTreeList) {
                            TreeNode newNode = new TreeNode(j);
                            newNode.left = copyTree(leftTree, 0);
                            dp[i].add(newNode);
                        }
                    } else {
                        for (TreeNode rightTree : rightTreeList) {
                            TreeNode newNode = new TreeNode(j);
                            newNode.right = copyTree(rightTree, j);
                            dp[i].add(newNode);
                        }
                    }
                }
            }
        }
        return dp[n];
    }

    private TreeNode copyTree(TreeNode node, int offset) {
        if (node == null) {
            return null;
        }
        TreeNode newNode = new TreeNode(node.val + offset);
        newNode.left = copyTree(node.left, offset);
        newNode.right = copyTree(node.right, offset);
        return newNode;
    }
}