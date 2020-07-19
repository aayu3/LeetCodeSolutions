package problem24;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode res = head.next;
        while (temp != null && temp.next != null) {
            // remove this
            ListNode node = temp;
            temp = temp.next;
            node.next = temp.next;
            temp.next = node;
            temp = node.next;
            if (temp != null && temp.next != null) node.next = temp.next;
        }
        return res;
    }
}
