class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->y[0]-x[0]);

        if(a!=0){pq.offer(new int[]{a,'a'});}
        if(b!=0){pq.offer(new int[]{b,'b'});}
        if(c!=0){pq.offer(new int[]{c,'c'});}

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){

            int[] curr = pq.poll();

            char x = (char)curr[1];

            if(sb.length()>=2 && sb.charAt(sb.length()-1)==x && sb.charAt(sb.length()-2)==x){
                if(pq.isEmpty()){
                    return sb.toString();
                }
                int[] next = pq.poll();
                next[0]--;
                if(next[0]>0){
                    pq.offer(next);
                }
                sb.append((char)next[1]);
                pq.offer(curr);
            }
            else{
                curr[0]--;
                if(curr[0]>0){
                    pq.offer(curr);
                }
                sb.append(x);
            }
        }

        return sb.toString();
    }
}