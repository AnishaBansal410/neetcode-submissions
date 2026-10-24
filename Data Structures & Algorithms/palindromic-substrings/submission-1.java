class Solution {
    public int countSubstrings(String s) {

        // boolean[][] dp = new boolean[s.length()][s.length()];
        int ans=0;
        // for(int i=0;i<s.length();i++){
        //     for(int j=i+1;j<s.length()+1;j++){
        //         if(isPalindrome(s,i,j-1)){
        //             dp[i][j-1]=true;
        //             ans++;
        //         }
        //     }
        // }
        for(int i=0;i<s.length();i++){
            ans+=expand(s,i,i);
            ans+=expand(s,i,i+1);
        }
        return ans;
    }

    public boolean isPalindrome(String s, int st,int end){
        while(st<=end){
            if(s.charAt(st)!=s.charAt(end)){
                return false;
            }
            st++;
            end--;
        }
        return true;
    }

    public int expand(String s, int st,int end){
        int count=0;

        while(st>=0 && end<s.length()){
            if(s.charAt(st)!=s.charAt(end)){
                break;
            }
            st--;
            end++;
            count++;
        }

        return count;
    }
}
