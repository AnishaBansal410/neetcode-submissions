class LRUCache {
    HashMap<Integer,Node> map;
    Node head;
    Node tail;
    int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        cap = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node n = map.get(key);
        remove(n);
        addToFront(n);
        return n.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            addToFront(n);
            n.value=value;
            return;            
        }

        if(cap==0){
            map.remove(tail.prev.key);
            remove(tail.prev);
            cap++;
        }

        Node n = new Node(key,value);
        map.put(key,n);
        addToFront(n);
        cap--;
    }

    public void addToFront(Node n){
        Node tmp = head.next;
        n.next=tmp;
        n.prev=head;
        head.next=n;
        tmp.prev=n;
    }

    public void remove(Node n){
        Node tmp = n.prev;
        Node tmp2 = n.next;

        if(tmp!=null){
            tmp.next = tmp2;
        }
        if(tmp2!=null){
            tmp2.prev = tmp;
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
