class LRUCache {

    HashMap<Integer,Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next=tail;
        tail.prev=head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        remove(map.get(key));
        addToFront(map.get(key));     
        return map.get(key).value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).value = value;
            remove(map.get(key));
            addToFront(map.get(key));
            return;
        }
        Node n = new Node(key,value);
        if(capacity==0){
            map.remove(tail.prev.key);
            remove(tail.prev);
            addToFront(n);
        }
        else{
            addToFront(n);
            capacity--;
        }
        map.put(key,n);
    }

    public void addToFront(Node node){
        Node tmp = head.next;
        tmp.prev = node;
        head.next = node;
        node.next=tmp;
        node.prev=head;
    }

    public void remove(Node node){
        if(node==null){
            return;
        }
        if(node.prev!=null){
            node.prev.next = node.next;
        }
        if(node.next!=null){
            node.next.prev = node.prev;
        }
    }
}

class Node{
    int key;
    int value;
    Node next;
    Node prev;

    Node(int k,int v){
        key=k;
        value=v;
        next=null;
        prev=null;
    }
}