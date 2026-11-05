class FreqStack {

    PriorityQueue<int[]> pq;

    HashMap<Integer,Integer> map;
    int index;

    public FreqStack() {
        map = new HashMap<>();
        pq = new PriorityQueue<>((a,b)->a[0]!=b[0] ? b[0]-a[0] : b[1]-a[1]);
        index=0;
    }
    
    public void push(int val) {
        map.put(val,map.getOrDefault(val,0)+1);
        pq.offer(new int[]{map.get(val),index++,val});
    }
    
    public int pop() {
        int[] top = pq.poll();
        map.put(top[2],map.get(top[2])-1);
        return top[2];
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */