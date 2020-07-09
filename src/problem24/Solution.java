package problem24;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class Solution {

        public ListNode swapPairs(ListNode head) {
            if (head.next == null) {
                return head;
            }
            else if (head.next.next == null) {
                head.next.next = head;
                head.next = null;
                return
            }
            else {

            }
        }

}
