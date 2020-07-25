package problem109;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head)
    {
        return buildTree(head,null);
    }
    public TreeNode buildTree(ListNode head,ListNode end)
    {
        if(head==end)
            return null;
        ListNode mid=getMid(head,end);
        //System.out.println(mid.val);
        TreeNode root=new TreeNode(mid.val);
        root.left=buildTree(head,mid);
        root.right=buildTree(mid.next,end);
        return root;
    }
    public ListNode getMid(ListNode head,ListNode x)
    {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=x && fast.next!=x)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}