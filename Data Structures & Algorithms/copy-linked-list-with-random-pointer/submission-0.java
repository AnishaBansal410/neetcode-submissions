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
        Node ans = head;
        map.put(head,new Node(head.val));
        while(head!=null){
            if(!map.containsKey(head.next) && head.next!=null){
                map.put(head.next,new Node(head.next.val));
            }
            if(!map.containsKey(head.random) && head.random!=null){
                map.put(head.random,new Node(head.random.val));
            }
            map.get(head).next = map.get(head.next);
            map.get(head).random = map.get(head.random);
            head=head.next;
        }
        return map.get(ans);
    }
}
