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
        ListNode test1 = convertToListNode(9);
        ListNode test2 = convertToListNode(9);
        ListNode result = addTwoNumbers(test1, test2);
        System.out.println(convertToInt(result));

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode firstNumDigit = l1;
        ListNode secondNumDigit = l2;
        int carry = carryCalc(firstNumDigit.val, secondNumDigit.val, /*prevcarry=*/0);
        ListNode sum = new ListNode((firstNumDigit.val + secondNumDigit.val) % 10);
        //base case where both numbers are 1 digit long
        ListNode nextDigitOfSum = null;
        if (firstNumDigit.next == null && secondNumDigit.next == null) {
            nextDigitOfSum = null;
            if (carry != 0) {
                nextDigitOfSum = new ListNode(carry, null);
            }
            sum.next = nextDigitOfSum;
            return sum;
        }
        sum.next = nextDigitOfSum;
        firstNumDigit = firstNumDigit.next;
        secondNumDigit = secondNumDigit.next;
        //both numbers are length 2 or greater
        if (firstNumDigit != null && secondNumDigit != null){
            nextDigitOfSum = new ListNode();
            nextDigitOfSum.val = (carry + firstNumDigit.val + secondNumDigit.val) % 10;
            carry = carryCalc(firstNumDigit.val,secondNumDigit.val, carry);
            sum.next = nextDigitOfSum;
            //add until one number ends, we use the check inside of the loop because of intricacies regarding nextDigitOfSum, see later comment
            while (true) {
                //if both numbers ended
                if (firstNumDigit.next == null && secondNumDigit.next == null) {
                    nextDigitOfSum.next = null;
                    if (carry != 0) {
                        nextDigitOfSum.next = new ListNode(carry, null);
                    }
                    return sum;
                }
                //if one of the numbers end, but the other doesn't we don't want to set nextDigitOfSum to an empty ListNode
                else if (firstNumDigit.next == null || secondNumDigit.next == null) {
                    firstNumDigit = firstNumDigit.next;
                    secondNumDigit = secondNumDigit.next;
                    break;
                }
                else {
                    nextDigitOfSum.next = new ListNode();
                    nextDigitOfSum = nextDigitOfSum.next;
                    firstNumDigit = firstNumDigit.next;
                    secondNumDigit = secondNumDigit.next;
                    nextDigitOfSum.val = (carry + firstNumDigit.val + secondNumDigit.val) % 10;
                    carry = carryCalc(firstNumDigit.val,secondNumDigit.val, carry);
                }
            }
        }
        ListNode longerNum;
        if (firstNumDigit != null) {
            longerNum = firstNumDigit;
        }
        else {
            longerNum = secondNumDigit;
        }
        if (sum.next == null) {
            nextDigitOfSum = new ListNode();
            nextDigitOfSum.val = (carry + longerNum.val) % 10;
            carry = carryCalc(longerNum.val, 0, carry);
            longerNum = longerNum.next;
            sum.next = nextDigitOfSum;
        }
        while (longerNum != null) {
            //nothing is carried, so we can just set the rest of numbers equal to the longer number
            if (carry == 0) {
                nextDigitOfSum.next = longerNum;
                return sum;
            }
            nextDigitOfSum.next = new ListNode();
            nextDigitOfSum = nextDigitOfSum.next;
            nextDigitOfSum.val = (carry + longerNum.val) % 10;
            carry = carryCalc(longerNum.val, 0, carry);
            longerNum = longerNum.next;
        }


        return sum;
    }
    private static int carryCalc(int num1, int num2, int prevCarry) {
        if (num1 + num2 + prevCarry >= 10) {
            return (num1+num2 + prevCarry)/10;
        }
        return 0;
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