package problem82;

import java.util.*;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        Map<Integer , Integer> map = new TreeMap<>();
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        while(head != null){
            map.put(head.val , map.getOrDefault(head.val , 0) + 1);
            head = head.next;
        }
        for(int i : map.keySet()) {
            if(map.get(i) == 1){
                ans.next = new ListNode(i);
                ans = ans.next;
            }
        }
        return dummy.next;
    }
}
