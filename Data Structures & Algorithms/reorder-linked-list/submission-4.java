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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode curr = slow.next;
        slow.next=null;

        ListNode prev=null;

        while(curr!=null){
            ListNode tmp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=tmp;
        }

        // Step 3: Merge alternately
        ListNode first = head;
        ListNode second = prev;

        while (second != null) {

            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }

    public ListNode merge(ListNode head,ListNode prev){
        ListNode dummy = new ListNode(0);
        ListNode curr=dummy;
        int flag=0;

        while(head!=null && prev!=null){
            if(flag==0){
                curr.next = new ListNode(head.val);
                head=head.next;
            }
            else{
                curr.next = new ListNode(prev.val);
                prev=prev.next;
            }
            flag = flag==0 ? 1 : 0;
            curr=curr.next;
        }

        if(head!=null){
            curr.next=head;
        }
        if(prev!=null){
            curr.next=prev;
        }

        return dummy.next;
    }
}
