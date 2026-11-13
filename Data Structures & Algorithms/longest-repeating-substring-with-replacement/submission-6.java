class Solution {
    public int characterReplacement(String s, int k) {
        int ans=0;

        for(char c='A';c<='Z';c++){
            ans=Math.max(ans,length(s,c,k));
        }

        return ans;
    }

    public int length(String s,char c,int k){
        int len=0;

        int i=0,j=0;

        while(j<s.length()){
            if(s.charAt(j)!=c){
                k--;
            }
            while(k<0 && i<j){
                if(s.charAt(i)!=c){k++;}
                i++;
            }

            len = Math.max(len,j-i+1);

            j++;
        }

        return len;
    }
}
