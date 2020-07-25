package problem108;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums == null || nums.length == 0)
        {
            return null;
        }

        return constructTree(nums, 0, nums.length-1);
    }

    private TreeNode constructTree(int[] nums, int low, int high)
    {


        if(low > high)
        {
            return null;
        }

        int mid = low + (high - low)/2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructTree(nums, low, mid-1);
        root.right = constructTree(nums, mid+1, high);

        return root;
    }
}