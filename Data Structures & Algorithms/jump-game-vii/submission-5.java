class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        boolean[] visited = new boolean[s.length()];
        visited[0]=true;
        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr==s.length()-1){
                return true;
            }

            int min = curr+minJump;
            int max = Math.min(curr+maxJump,s.length()-1);

            for(int i=min;i<=max && i<s.length();i++){
                if(!visited[i] && s.charAt(i)=='0'){
                    q.offer(i);
                    visited[i]=true;
                }
            }
        }

        return false;
    }
}