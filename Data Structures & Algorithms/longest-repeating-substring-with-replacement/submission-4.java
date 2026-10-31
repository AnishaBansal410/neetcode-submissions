class Solution {
    public int characterReplacement(String s, int k) {
        int ans=0;
        for(char c='A';c<='Z';c++){
            ans = Math.max(ans,longestString(s,c,k));
        }

        return ans;
    }

    public int longestString(String s,char c, int k){

        int i=0;
        int j=0;
        int ans=0;

        while(j<s.length()){
            if(s.charAt(j)!=c){
                k--;
            }
            while(i<j && k<0){
                if(s.charAt(i)!=c){
                    k++;
                }
                i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
        }

        return ans;
    }
}
