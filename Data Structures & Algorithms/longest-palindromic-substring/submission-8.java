class Solution {

    String ans="";

    public String longestPalindrome(String s) {
        for(int i=0;i<s.length();i++){
            check(s,i,i);
            check(s,i,i+1);
        }
        return ans;
    }

    public void check(String s,int st,int end){
        while(st>=0 && end<s.length() && s.charAt(st)==s.charAt(end)){
            st--;
            end++;
        }
        if(ans.length()<end-st-1){
            ans = s.substring(st+1,end);
        }
    }
}
