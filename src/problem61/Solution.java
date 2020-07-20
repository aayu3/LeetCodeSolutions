package problem61;

import java.util.*;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len = len + 1;
        }
        tail.next = head;
        // find the pre node of Kth from end
        for (int i = len - k%len; i > 0; --i) {
            tail = tail.next;
        }
        ListNode res = tail.next;
        tail.next = null;
        return res;
    }
}