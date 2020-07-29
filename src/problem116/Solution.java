package problem116;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null || root.left == null) {
            return root;
        }
        Queue<Node> nodes = new LinkedList();
        nodes.add(root.left);
        nodes.add(root.right);
        int evictCount = 1;
        while (nodes.peek() != null) {
            Node firstNode = nodes.remove();
            evictCount++;
            Node secondNode = nodes.peek();
            if ((evictCount+1 & evictCount) != 0) { // Validate if its not the last node of the level
                firstNode.next = secondNode;
            }
            nodes.add(firstNode.left);
            nodes.add(firstNode.right);
        }
        return root;
    }
}