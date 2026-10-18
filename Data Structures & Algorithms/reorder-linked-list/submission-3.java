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

        if(head==null){
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow.next;
        slow.next=null;
        
        curr = reverse(curr);
        curr = merge(head,curr);
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;

        while(head!=null){
            ListNode tmp = head.next;
            head.next=prev;
            prev=head;
            head=tmp;
        }

        return prev;
    }

    public ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        boolean flag = true;
        while(l1!=null && l2!=null){
            if(flag){
                head.next = l1;
                l1=l1.next;
            }
            else{
                head.next = l2;
                l2=l2.next;
            }
            head=head.next;
            flag=!flag;
        }

        if(l1!=null){
            head.next=l1;
        }
        if(l2!=null){
            head.next = l2;
        }
        return dummy.next;
    }
}
