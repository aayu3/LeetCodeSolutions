package problem25;


 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode();
        result.next = head;
        ListNode current = head;
        ListNode prev = result;

        while(current!=null){
            ListNode start = current;
            int count = 0;

            //first move current pointer till k index
            while(current!=null && count!=k){
                current=current.next;
                count++;
            }

            //if count is k it means we can reverse from start till k values
            //after reverse need to point the prev.next to reversed list
            //also need to assign make prev = start so we can point prev.next in next iteration
            if(count==k){
                prev.next = reverse(start,k);
                prev = start;
            }

            //if count is not equals k it means we need not reverse the list
            //we can simply assign prev.next to start.
            else{
                prev.next = start;
            }
        }
        return result.next;
    }

    public ListNode reverse(ListNode head, int k){
        ListNode prev = null;
        int count = 0;
        while(count!=k && head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            count+=1;
        }
        return prev;
    }
}