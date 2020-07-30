package problem117;

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
        Node head = new Node(Integer.MIN_VALUE), node = root, level;
        while (node != null) {
            for (level = head; node != null; node = node.next) {
                if (node.left != null) {
                    level.next = node.left;
                    level = level.next;
                }
                if (node.right != null) {
                    level.next = node.right;
                    level = level.next;
                }
            }
            node = head.next;
            head.next = null;
        }
        return root;
    }
}