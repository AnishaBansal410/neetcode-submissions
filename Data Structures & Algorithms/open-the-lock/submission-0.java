class Solution {
    public int openLock(String[] deadends, String target) {
        int ans=0;
        Queue<String> q = new LinkedList<>();
        HashSet<String> deadend = new HashSet<>();
        for(String s:deadends){
            deadend.add(s);
        }
        if (deadend.contains("0000")) return -1;
        if (target.equals("0000")) return 0;
        HashSet<String> visited = new HashSet<>();
        q.offer("0000");
        visited.add("0000");
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String curr=q.poll();
                List<String> neighbors = getNeighbors(curr);
                for(String s:neighbors){
                    if(s.equals(target)){
                        return ans+1;
                    }
                    if(deadend.contains(s) || visited.contains(s)){
                        continue;
                    } 
                    q.offer(s);
                    visited.add(s);
                }
            }
            ans++;
        }
        return -1;
    }
    public List<String> getNeighbors(String lock) {
    
        List<String> neighbors = new ArrayList<>();
        char[] chars = lock.toCharArray();

        for (int i = 0; i < 4; i++) {
            char original = chars[i];

            // Rotate forward
            chars[i] = (char) ((original - '0' + 1) % 10 + '0');
            neighbors.add(new String(chars));

            // Rotate backward
            chars[i] = (char) ((original - '0' + 9) % 10 + '0');
            neighbors.add(new String(chars));

            // Restore
            chars[i] = original;
        }

        return neighbors;
    }
}