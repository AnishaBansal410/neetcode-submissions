class Solution {
    public int characterReplacement(String s, int k) {
        int ans=0;
        for(char i='A';i<='Z';i++){
            ans=Math.max(ans,maxLength(s,i,k));
        }
        return ans;
    }

    public int maxLength(String s,char c,int k){
        int i=0,j=0;
        int ans=0;
        while(j<s.length()){
            if(s.charAt(j)!=c){
                k--;
            }
            while(k<0){
                if(s.charAt(i)!=c){
                    k++;
                }
                i++;
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}
