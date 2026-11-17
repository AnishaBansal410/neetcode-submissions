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

            boolean dead=false;

            while(!st.isEmpty() && st.peek()>0 && !dead){
                if(st.peek()>Math.abs(curr)){
                    dead=true;
                }
                else if(st.peek()==Math.abs(curr)){
                    dead=true;
                    st.pop();
                }
                else{
                    st.pop();
                }
            }

            if(!dead){
                st.push(curr);
            }
        }

        int[] ans = new int[st.size()];

        int i = st.size()-1;

        while(!st.isEmpty()){
            ans[i--]=st.pop();
        }

        return ans;
    }
}