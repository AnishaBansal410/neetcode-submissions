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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        if(lists.length==0){
            return ans;
        }
        int i=0;
        while(i<lists.length){
            ans=mergeTwoLists(ans,lists[i]);
            i++;
        }
        return ans;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                head.next=l1;
                l1=l1.next;
            }
            else{
                head.next=l2;       
                l2=l2.next;   
            }
            head=head.next;
        }
        while(l1!=null){
            head.next=l1;
            head=head.next;
            l1=l1.next;
        }
        while(l2!=null){
            head.next=l2;
            head=head.next;
            l2=l2.next;
        }
        return dummy.next;
    }
}
