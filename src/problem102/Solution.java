package problem102;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> arr = new ArrayList<>();


        level(root, arr, 0);

        return arr;
    }

    public void level(TreeNode root, List<List<Integer>> arr, int height) {

        if (root == null) {
            return;
        }

        if(arr.size() < height+1) {
            arr.add(new ArrayList<>());
        }

        arr.get(height).add(root.val);
        level(root.left, arr, height+1);
        level(root.right, arr, height+1);
    }
}
        }
}