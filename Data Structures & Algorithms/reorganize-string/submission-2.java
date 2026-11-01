class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];

        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);

        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                pq.offer(new int[]{i,freq[i]});
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            char c = (char)(curr[0]+(int)'a');
            if(sb.length()>=1 && sb.charAt(sb.length()-1)==c){
                if(pq.isEmpty()){
                    return "";
                }
                int[] next = pq.poll();
                char n = (char)(next[0]+(int)'a');
                next[1]--;
                if(next[1]>0){
                    pq.offer(next);
                }
                sb.append(n);
                pq.offer(curr);
            }
            else{
                sb.append(c);
                curr[1]--;
                if(curr[1]>0){
                    pq.offer(curr);
                }
            }
        }

        return sb.toString();
    }
}