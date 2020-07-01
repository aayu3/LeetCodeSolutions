package problem2;

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

class Solution {
    public static void main(String[] args) {
        ListNode test1 = convertToListNode(2);
        ListNode test2 = convertToListNode(9);
        ListNode result = addTwoNumbers(test1, test2);
        System.out.println(convertToInt(result));

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //will be adding in place on top of l1, so l1Incr is the return value
        ListNode l1Incr = l1;
        ListNode l2Incr = l2;
        ListNode pointer = new ListNode(0,l1Incr);
        int carry = 0;
        //reason I always check whether foo.next != null instead of foo != null is i want to be able to set foo.next, if foo is null
        //then foo.next will raise an error
        while (l1Incr.next != null) {
            if (l2Incr == null) {
                while (l1Incr.next != null) {
                    if (carry == 0) {
                        return pointer.next;
                    }
                    carry += l1Incr.val;
                    l1Incr.val = carry % 10;
                    carry /= 10;
                    l1Incr = l1Incr.next;
                }
                carry += l1Incr.val;
                l1Incr.val = carry%10;
                carry /= 10;
                if (carry == 1) {
                    l1Incr.next = new ListNode(1,null);
                }
                return pointer.next;
            }
            carry = carry + l1Incr.val + l2Incr.val;
            l1Incr.val = carry%10;
            carry /= 10;
            l1Incr = l1Incr.next;
            l2Incr = l2Incr.next;
        }
        //this happens regardless
        carry += l1Incr.val;
        if (l2Incr == null) {
            l1Incr.val = carry%10;
            carry /= 10;
            if (carry == 1) {
                l1Incr.next = new ListNode(1,null);
            }
            return pointer.next;
        }
        carry += l2Incr.val;
        l1Incr.val = carry%10;
        carry /= 10;
        l1Incr.next = l2Incr.next;
        while (l1Incr.next != null) {
            if (carry == 0) {
                return pointer.next;
            }
            l1Incr = l1Incr.next;
            carry += l1Incr.val;
            l1Incr.val = carry%10;
            carry /= 10;

        }
        if (carry == 1) {
            l1Incr.next = new ListNode(1,null);
        }
        return pointer.next;
    }
    private static ListNode convertToListNode(int num) {
        int temp = num;
        ListNode root = new ListNode(temp % 10);
        temp /= 10;
        if (temp == 0) {
            root.next = null;
            return root;
        }
        ListNode nextNode = new ListNode();
        root.next = nextNode;

        while (temp/10 > 0) {
            nextNode.val = temp % 10;
            temp /= 10;
            nextNode.next = new ListNode();
            nextNode = nextNode.next;
        }
        nextNode.val = temp%10;
        nextNode.next = null;
        return root;
    }
    private static int convertToInt(ListNode num) {
        int result = 0;
        ListNode curDigit = num;
        int multiplier = 1;
        while (curDigit != null) {
            result += multiplier * curDigit.val;
            curDigit = curDigit.next;
            multiplier *= 10;
        }
        return result;
    }
}