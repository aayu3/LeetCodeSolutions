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
class CheekySolution {
    public static void main(String[] args) {

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return convertToListNode(Long.sum(convertToLong(l1),convertToLong(l2)));
    }
    private static int longModTen(long num) {
        String temp = Long.toString(num);
        return Character.getNumericValue(temp.charAt(temp.length()-1));

    }
    private static ListNode convertToListNode(long num) {
        long temp = num;
        ListNode root = new ListNode(longModTen(temp));
        temp /= 10;
        if (temp == 0) {
            root.next = null;
            return root;
        }
        ListNode nextNode = new ListNode();
        root.next = nextNode;

        while (temp/10 > 0) {
            nextNode.val = longModTen(temp);
            temp /= 10;
            nextNode.next = new ListNode();
            nextNode = nextNode.next;
        }
        nextNode.val = longModTen(temp);
        nextNode.next = null;
        return root;
    }
    private static long convertToLong(ListNode num) {
        long result = 0;
        ListNode curDigit = num;
        long multiplier = 1;
        while (curDigit != null) {
            result += multiplier * curDigit.val;
            curDigit = curDigit.next;
            multiplier *= 10;
        }
        return result;
    }
}