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
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode curr = slow.next;
        slow.next=null;
        ListNode prev = null;
        while(curr!=null){
            ListNode tmp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=tmp;
        }
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        curr=dummy;
        boolean flag=true;
        while(head!=null && prev!=null){
            if(flag){
                curr.next=head;
                head=head.next;
                flag=false;
            }
            else{
                curr.next=prev;
                prev=prev.next;
                flag=true;
            }
            curr=curr.next;
        }
        curr.next=head;
    }
}
