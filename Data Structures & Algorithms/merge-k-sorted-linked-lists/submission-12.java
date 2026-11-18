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
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);

        for(ListNode node : lists){
            if(node!=null){
                pq.offer(node);
            }
        }

        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            head.next = curr;
            if(curr.next!=null){
                pq.offer(curr.next);
            }
            head=head.next;
        }

        return dummy.next;
    }
}
