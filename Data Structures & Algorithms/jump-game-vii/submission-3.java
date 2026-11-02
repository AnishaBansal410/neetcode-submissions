class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        boolean[] visited = new boolean[s.length()];
        visited[0] = true;

        while(!q.isEmpty()){

            int currIdx = q.poll();
            
            if(currIdx==s.length()-1){
                return true;
            }

            int min = currIdx+minJump;
            int max = Math.min(currIdx+maxJump,s.length()-1);

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