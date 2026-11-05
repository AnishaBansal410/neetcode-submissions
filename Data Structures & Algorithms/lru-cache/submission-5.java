class LRUCache {

    Node head;
    Node tail;
    int cap;
    HashMap<Integer,Node> map;

    public LRUCache(int capacity) {
        cap = capacity;

        head = new Node(0,0);
        tail = new Node(0,0);

        head.next=tail;
        tail.prev=head;

        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        addToFront(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            addToFront(node);
            node.value = value;  
            return; 
        }

        if(cap==0){
            map.remove(tail.prev.key);
            remove(tail.prev);
            cap++;
        }

        map.put(key,new Node(key,value));
        addToFront(map.get(key));
        cap--;
    }

    public void addToFront(Node node){
        Node next = head.next;
        head.next=node;
        node.prev=head;
        next.prev=node;
        node.next=next;
    }

    public void removeFromEnd(){
        Node node = tail.prev;

        if(node.prev==null){
            return; 
        }

        Node previous = node.prev;

        previous.next=tail;
        tail.prev = previous;
    }

    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next=next;
        next.prev=prev;
    }
}

class Node{
    int key;
    int value;
    Node next;
    Node prev;

    Node(int k,int v){
        this.key=k;
        this.value=v;
        this.next=null;
        this.prev=null;
    }
}