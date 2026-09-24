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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode node : lists){
            if(node==null){
                continue;
            }
            pq.add(node);
        }
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            curr.next = node;
            if(node.next!=null){
                pq.offer(node.next);
            }
            curr = curr.next;
        }

        return head.next;
    }

    public ListNode merge(ListNode first,ListNode second){
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while(first!=null && second!=null){
            if(first.val<second.val){
                curr.next = first;
                first=first.next;
            }
            else{
                curr.next = second;
                second=second.next;
            }
            curr = curr.next;
        }

        if(first!=null){
            curr.next=first;
        }
        if(second!=null){
            curr.next=second;
        }

        return head.next;
    }
}
