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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || left==right){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        ListNode curr=head;
        int i=1;
        while(curr!=null && i<left){
            curr=curr.next;
            prev=prev.next;
            i++;
        }
        ListNode curr2=curr;
        ListNode prev2=prev;
        while(curr!=null && i<=right){
            ListNode tmp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=tmp;
            i++;
        }
        prev2.next=prev;
        curr2.next=curr;
        return dummy.next;
    }
}