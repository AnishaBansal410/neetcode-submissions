class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<asteroids.length;i++){

            int asteroid = asteroids[i]; 

            if(asteroid>0){
                st.push(asteroid);
            }
            else{
                boolean dead=false;
                if(st.isEmpty() || st.peek()<0){
                    st.push(asteroid);
                    continue;
                }
                
                while(!st.isEmpty() && st.peek()>0 && !dead){
                    if(st.peek()==Math.abs(asteroid)){
                        st.pop();
                        dead=true;
                    }
                    else if(st.peek()<Math.abs(asteroid)){
                        st.pop();
                    }
                    else{
                        dead=true;
                    }
                }

                if(!dead){
                    st.push(asteroid);
                }
            }
        }

        int[] ans = new int[st.size()];
        int i=st.size()-1;

        while(!st.isEmpty()){
            ans[i--]=st.pop();
        }
        return ans;
    }
}