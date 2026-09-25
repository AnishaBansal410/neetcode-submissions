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
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the linked list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Split the list and reverse the second half
        ListNode curr = slow.next;
        slow.next = null; // CRITICAL: Disconnect the first half to prevent cycles!
        curr = reverseList(curr);

        // Step 3: Merge the two halves alternately
        ListNode first = head;
        ListNode second = curr;
        
        while (second != null) {
            // Save next pointers
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            // Rewire pointers to interleave
            first.next = second;
            second.next = tmp1;

            // Move pointers forward
            first = tmp1;
            second = tmp2;
        }
    }

    private ListNode reverseList(ListNode node) {
        ListNode curr = node;
        ListNode prev = null;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }
}

