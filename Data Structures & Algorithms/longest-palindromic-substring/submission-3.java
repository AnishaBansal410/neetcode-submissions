class Solution {
    public String longestPalindrome(String s) {
        String ans="";
        for(int i=0;i<s.length();i++){
            ans=longest(s,i,i,ans);
            ans=longest(s,i,i+1,ans);
        }
        return ans;
    }

    public String longest(String s,int i,int j,String ans){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        String tmp = s.substring(i+1,j);
        if(tmp.length()>ans.length()){
            return tmp;
        }
        return ans;
    }
}
