class Solution {
    public int characterReplacement(String s, int k) {
        int ans=0;

        for(char i='A';i<='Z';i++){
            ans=Math.max(ans,length(s,k,i));
        }

        return ans;
    }

    public int length(String s,int k,char c){
        int ans=0;

        int i=0,j=0;

        while(j<s.length()){
            if(s.charAt(j)!=c){
                k--;
            }
            while(i<=j && k<0){
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
