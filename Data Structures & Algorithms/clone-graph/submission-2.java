/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        HashMap<Node,Node> map = new HashMap<>();
        clone(node,map);
        return map.get(node);
    }

    public Node clone(Node node,HashMap<Node,Node> map){
        if(map.containsKey(node)){
            return map.get(node);
        }
        map.put(node,new Node(node.val));
        for(Node neighbor : node.neighbors){
            clone(neighbor,map);
            map.get(node).neighbors.add(map.get(neighbor));
        }
        return map.get(node);
    }
}