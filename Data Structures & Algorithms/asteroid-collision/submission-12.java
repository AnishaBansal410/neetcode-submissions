class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<asteroids.length;i++){
            int curr = asteroids[i];
            if(curr>0){
                st.push(curr);
                continue;
            }
            if(st.isEmpty() || st.peek()<0){
                st.push(curr);
                continue;
            }
            boolean dead = false;
            while(!st.isEmpty() && st.peek()>0 && Math.abs(curr)>=st.peek() && !dead){
                if(Math.abs(curr)>st.peek()){
                    st.pop();
                }
                else{
                    dead=true;
                    st.pop();
                }
            }
            if((st.isEmpty()||st.peek()<0) && !dead){
                st.push(curr);
            }
        }
        ArrayList<Integer> arr = new ArrayList<>(st); 
        int[] ans = new int[arr.size()];
        int i=0;
        for(int j:arr){
            ans[i++]=j;
        }
        return ans;
    }
}