package problem103;


  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList();
        List<List<Integer>> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        boolean reverseLevel = false;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList();
            while (levelSize-- > 0) {
                root = queue.poll();
                level.add(root.val);
                if (root.left != null)
                    queue.add(root.left);
                if (root.right != null)
                    queue.add(root.right);
            }
            if (reverseLevel)
                Collections.reverse(level);
            result.add(level);
            reverseLevel = !reverseLevel;
        }

        return result;
    }
}