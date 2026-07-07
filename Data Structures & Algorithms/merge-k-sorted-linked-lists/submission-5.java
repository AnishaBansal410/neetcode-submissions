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
        if(lists.length==0){
            return null;
        }
        return divideAndMerge(lists,0,lists.length-1);
    }

    public ListNode divideAndMerge(ListNode[] lists,int left,int right){
        if(left==right){
            return lists[left];
        }
        int mid=left+(right-left)/2;
        ListNode tmp1 = divideAndMerge(lists,left,mid);
        ListNode tmp2 = divideAndMerge(lists,mid+1,right);
        return mergeTwoLists(tmp1,tmp2);
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
        head.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
