class LRUCache {

    Node head;
    Node tail;
    HashMap<Integer,Node> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            moveToFront(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            moveToFront(node);
            node.value = value;
            return;
        }

        if(this.capacity==0){
            Node node = this.tail.prev;
            remove(node);
            map.remove(node.key); 
            this.capacity++;
        }
        Node curr = new Node(key,value);
        map.put(key,curr);
        moveToFront(curr);
        this.capacity--;
    }

    public void remove(Node node){
        if(node==null || node.prev==null || node.next==null){
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToFront(Node node){
        Node next = this.head.next;
        next.prev = node;
        node.next = next;
        this.head.next = node;
        node.prev = this.head;
    }

    public void removeFromEnd(){
        Node node = this.tail.prev;
    }
}

class Node{
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int k,int v){
        this.key = k;
        this.value = v;
        this.next = null;
        this.prev = null;
    } 
}
