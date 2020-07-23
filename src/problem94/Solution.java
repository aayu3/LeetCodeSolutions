package problem94;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;

        Stack<TreeNode> stack = new Stack<>();
        populate(stack,root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);

            populate(stack,node.right);
        }

        return list;
    }

    public void populate(Stack<TreeNode> stack,TreeNode node){
        while(node!=null){
            stack.push(node);
            node=node.left;
        }
    }
}