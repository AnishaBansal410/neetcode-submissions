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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head=dummy;
        int carry=0;
        while(l1!=null && l2!=null){
            int tmp = l1.val+l2.val+carry;
            head.next=new ListNode(tmp%10);
            carry=tmp/10;
            l1=l1.next;
            l2=l2.next;
            head=head.next;
        }
        while(l1!=null){
            head.next=new ListNode((l1.val+carry)%10);
            carry=(l1.val+carry)/10;
            head=head.next;
            l1=l1.next;
        }
        while(l2!=null){
            head.next=new ListNode((l2.val+carry)%10);
            carry=(l2.val+carry)/10;
            head=head.next;
            l2=l2.next;
        }
        if(carry==1){
            head.next=new ListNode(1);
        }
        return dummy.next;
    }
}
