class FreqStack {

    PriorityQueue<int[]> pq;
    HashMap<Integer,Integer> map;
    int idx;

    public FreqStack() {
        pq = new PriorityQueue<>((a,b)->a[1]!=b[1] ? b[1]-a[1] : b[2]-a[2]);
        map = new HashMap<>();
        idx = 0;
    }
    
    public void push(int val) {

        map.put(val,map.getOrDefault(val,0)+1);

        pq.offer(new int[]{val,map.get(val),idx++});
    }
    
    public int pop() {
        if(pq.isEmpty()){
            return -1;
        }

        int[] curr = pq.poll();
        map.put(curr[0],map.get(curr[0])-1);

        return curr[0];
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */