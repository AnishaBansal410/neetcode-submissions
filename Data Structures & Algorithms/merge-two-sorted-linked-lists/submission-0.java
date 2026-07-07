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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                ListNode tmp = new ListNode(l1.val);
                head.next=tmp;
                l1=l1.next;
            }
            else{
                ListNode tmp = new ListNode(l2.val);
                head.next=tmp;       
                l2=l2.next;   
            }
            head=head.next;
        }
        while(l1!=null){
            ListNode tmp = new ListNode(l1.val);
            head.next=tmp;
            head=head.next;
            l1=l1.next;
        }
        while(l2!=null){
            ListNode tmp = new ListNode(l2.val);
            head.next=tmp;
            head=head.next;
            l2=l2.next;
        }
        return dummy.next;
    }
}