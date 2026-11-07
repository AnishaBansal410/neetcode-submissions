class Solution {
    public int countSubstrings(String s) {
        
        int ans=0;

        for(int i=0;i<s.length();i++){
            ans+=palindromes(s,i,i);
            ans+=palindromes(s,i,i+1);
        }

        return ans;
    }

    public int palindromes(String s,int st,int end){
        int ct=0;

        while(st>=0 && end<s.length() && s.charAt(st)==s.charAt(end)){
            st--;
            end++;
            ct++;
        }

        return ct;
    }
}
