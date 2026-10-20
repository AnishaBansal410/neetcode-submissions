class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];

        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);

        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                pq.offer(new int[]{freq[i],i+'a'});
            }
        }

        StringBuilder str = new StringBuilder();

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(str.length()>0 && str.charAt(str.length()-1)==curr[1]){
                if(pq.isEmpty()){
                    return "";
                }
                int[] next = pq.poll();
                str.append((char)next[1]);
                next[0]--;
                if(next[0]>0){
                    pq.offer(next);
                }
                pq.offer(curr);
                continue;
            }
            str.append((char)curr[1]);
            curr[0]--;
            if(curr[0]>0){
                pq.offer(curr);
            }
        }

        return str.toString();
    }
}