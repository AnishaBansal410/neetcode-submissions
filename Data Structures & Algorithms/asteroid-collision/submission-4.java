class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            boolean destroyed=false;
            if(asteroids[i]<0){
                if(st.isEmpty() || st.peek()<0){
                    st.push(asteroids[i]);
                    continue;
                }
                while(!st.isEmpty() && st.peek()>0 && st.peek()<=Math.abs(asteroids[i])){
                    if(st.peek()==Math.abs(asteroids[i])){
                        destroyed=true;
                        st.pop();
                        break;
                    }
                    st.pop();
                }
                if(!destroyed && (st.isEmpty()||st.peek()<0)){
                    st.push(asteroids[i]);
                }
            }
            else{
                st.push(asteroids[i]);
            }
        }
        int[] ans = new int[st.size()];
        int j=0;
        for(Integer num:st){
            ans[j++]=num;
        }
        return ans;
    }
}