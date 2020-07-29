package problem114;

class Solution {
    public void flatten(TreeNode root) {
        if(root == null)
            return;

        // lets reach the leaf node first.
        flatten(root.left);
        flatten(root.right);

        // Storing this so that it can be attached at to the end
        TreeNode right = root.right;
        // will use this to iterate next (right in this case)
        TreeNode curr = root;

        // move what is left of the node to the right and remove left
        root.right = root.left;
        root.left = null;

        // keep going right till leaf node and attach right (stored) at the end.
        while(curr.right != null) curr = curr.right;
        curr.right = right;
    }
}