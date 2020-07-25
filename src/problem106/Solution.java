package problem106;

class Solution {
    private HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0; i<inorder.length; i++) map.put(inorder[i],i);
        return build(inorder,0,inorder.length-1, postorder,0,postorder.length-1);
    }

    private TreeNode build(int[] inorder, int startI, int endI, int[] postorder, int startP, int endP){
        if(startI>endI) return null;

        int rootIndex = map.get(postorder[endP]);
        TreeNode root = new TreeNode(inorder[rootIndex]);

        root.left = build(inorder, startI, rootIndex-1, postorder, startP, startP+(rootIndex-startI)-1);
        root.right = build(inorder,rootIndex+1, endI, postorder, startP+(rootIndex-startI), endP-1);
        return root;
    }
}