class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]>0){
                st.push(asteroids[i]);
                continue;
            }
            boolean dead=false;
            if(st.isEmpty() || (!st.isEmpty() && st.peek()<0)){
                st.push(asteroids[i]);
                continue;
            }

            while(!st.isEmpty() && st.peek()>0 && !dead){
                if(Math.abs(asteroids[i])>st.peek()){
                    st.pop();
                }
                else if(Math.abs(asteroids[i])==st.peek()){
                    dead=true;
                    st.pop();
                }
                else{
                    dead=true;
                }
            }
            if(!dead){
                st.push(asteroids[i]);
            }
        }

        int[] ans = new int[st.size()];

        for(int i=st.size()-1;i>=0;i--){
            ans[i]=st.pop();
        }

        return ans;
    }
}