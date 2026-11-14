class Solution {

    String ans="";

    public String longestPalindrome(String s) {

        for(int i=0;i<s.length();i++){
            length(s,i,i);
            length(s,i,i+1);
        }

        return ans;
    }

    public void length(String s,int st,int end){
        while(st>=0 && end<s.length() && s.charAt(st)==s.charAt(end)){
            st--;
            end++;
        }

        if(end-st-1>ans.length()){
            ans = s.substring(st+1,end);
        }
    }
}
