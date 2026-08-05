class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty()){
            maxHeap.offer(num);
            return;
        }
        if(num<maxHeap.peek()){
            maxHeap.offer(num);
            if(maxHeap.size()-minHeap.size()>1){
                minHeap.offer(maxHeap.poll());
            }
        }
        else{
            minHeap.offer(num);
            if(minHeap.size()>maxHeap.size()){
                maxHeap.offer(minHeap.poll());
            }
        }
    }
    
    public double findMedian() {
        if(maxHeap.size()>minHeap.size()){
            return maxHeap.peek();
        }
        return (double)(maxHeap.peek()+minHeap.peek())/2;
    }
}
