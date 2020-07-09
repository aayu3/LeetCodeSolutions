package problem23;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class Solution {

    /* Takes two lists sorted in increasing order, and merge
    their nodes together to make one big sorted list. Below
    function takes O(Log n) extra space for recursive calls,
    but it can be easily modified to work with same time and
    O(1) extra space  */
    public static ListNode SortedMerge(ListNode a, ListNode b)
    {
        ListNode result = null;
        /* Base cases */
        if (a == null)
            return b;
        else if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if (a.val <= b.val) {
            result = a;
            result.next = SortedMerge(a.next, b);
        }
        else {
            result = b;
            result.next = SortedMerge(a, b.next);
        }

        return result;
    }

    // The main function that takes an array of lists
    // arr[0..last] and generates the sorted output
    public static ListNode mergeKList(ListNode arr[], int last)
    {
        // repeat until only one list is left
        while (last != 0) {
            int i = 0, j = last;

            // (i, j) forms a pair
            while (i < j) {
                // merge List i with List j and store
                // merged list in List i
                arr[i] = SortedMerge(arr[i], arr[j]);

                // consider next pair
                i++;
                j--;

                // If all pairs are merged, update last
                if (i >= j)
                    last = j;
            }
        }

        return arr[0];
    }

    /* Function to print nodes in a given linked list */
    public static void printList(ListNode node)
    {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 1) {
            return lists[0];
        }
        else if (lists.length == 0) {
            return null;
        }
        return mergeKList(lists, lists.length-1);
    }

    public static void main(String args[])
    {
        int k = 3; // Number of linked lists
        int n = 4; // Number of elements in each list

        // an array of pointers storing the head nodes
        // of the linked lists
        ListNode arr[] = new ListNode[k];

        arr[0] = new ListNode(1);
        arr[0].next = new ListNode(3);
        arr[0].next.next = new ListNode(5);
        arr[0].next.next.next = new ListNode(7);

        arr[1] = new ListNode(2);
        arr[1].next = new ListNode(4);
        arr[1].next.next = new ListNode(6);
        arr[1].next.next.next = new ListNode(8);

        arr[2] = new ListNode(0);
        arr[2].next = new ListNode(9);
        arr[2].next.next = new ListNode(10);
        arr[2].next.next.next = new ListNode(11);

        // Merge all lists
        ListNode head = mergeKList(arr, arr.length-1);
        printList(head);
    }
}
