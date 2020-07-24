package problem105;

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
    private HashMap<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    private TreeNode build(int[] preorder, int startP, int endP, int[] inorder, int startI, int endI){
        if(startI>endI) return null;

        TreeNode root = new TreeNode(preorder[startP]);
        int rootIndex = map.get(root.val);

        root.left = build(preorder,startP+1,(rootIndex-startI),inorder, startI, rootIndex-1);
        root.right = build(preorder,startP+1+rootIndex-startI, endP, inorder, rootIndex+1, endI);
        return root;
    }
}