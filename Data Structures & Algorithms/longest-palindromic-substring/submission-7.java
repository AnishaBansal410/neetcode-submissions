class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        for(int i=0;i<s.length();i++){
            ans = findLongest(s,i,i,ans);
            ans = findLongest(s,i,i+1,ans);
        }

        return ans;
    }

    public String findLongest(String s, int i,int j,String ans){
        while(i>=0 && j<s.length()){
            if(s.charAt(i)!=s.charAt(j)){
                String tmp = s.substring(i+1,j);
                if(ans.length()<tmp.length()){
                    return tmp;
                }
                return ans;
            }
            i--;
            j++;
        }
        String tmp = s.substring(i+1,j);
        if(ans.length()<tmp.length()){
            return tmp;
        }
        return ans;
    }
}
