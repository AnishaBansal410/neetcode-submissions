/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        HashMap<Node,Node> map = new HashMap<>();
        map.put(head,new Node(head.val));
        Node curr = head;
        while(curr!=null){
            if(!map.containsKey(curr.random) && curr.random!=null){
                map.put(curr.random,new Node(curr.random.val));
            }
            if(!map.containsKey(curr.next) && curr.next!=null){
                map.put(curr.next,new Node(curr.next.val));
            }
            map.get(curr).random = map.get(curr.random);
            map.get(curr).next = map.get(curr.next);
            curr=curr.next;
        }

        return map.get(head);
    }
}
