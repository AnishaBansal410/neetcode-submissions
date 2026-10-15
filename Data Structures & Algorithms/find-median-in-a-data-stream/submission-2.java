class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty()){
            maxHeap.offer(num);
            return;
        }
        if(num<maxHeap.peek()){
            maxHeap.offer(num);
        }
        else{
            minHeap.offer(num);
        }
        while(minHeap.size()>maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
        if(maxHeap.size()-minHeap.size()>1){
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (double)(maxHeap.peek()+minHeap.peek())/2.0;
        }
        return (double)maxHeap.peek();
    }
}
