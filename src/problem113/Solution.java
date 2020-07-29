package problem113;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPathReccursively(root, sum, currentPath, result);
        return result;
    }

    private void findPathReccursively(TreeNode currentNode, int sum, List<Integer> currentPath, List<List<Integer>> result) {
        if (currentNode == null) {
            return;
        }

        currentPath.add(currentNode.val);

        if (currentNode.val == sum && currentNode.left == null && currentNode.right == null) {
            result.add(new ArrayList<>(currentPath));
        } else {
            findPathReccursively(currentNode.left, sum - currentNode.val, currentPath, result);
            findPathReccursively(currentNode.right, sum - currentNode.val, currentPath, result);
        }

        currentPath.remove(currentPath.size() - 1);
    }
}