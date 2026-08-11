class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        int stIndex=0;
        for(int i=0;i<s.length();i++){
            int l=i,r=i;
            while(l>=0 && r<=s.length()-1 && s.charAt(l)==s.charAt(r)){
                if(r-l+1>maxLength){
                    stIndex=l;
                    maxLength = r-l+1;
                }
                l--;r++;
            }
            l=i;
            r=i+1;
            while(l>=0 && r<=s.length()-1 && s.charAt(l)==s.charAt(r)){
                if(r-l+1>maxLength){
                    stIndex=l;
                    maxLength = r-l+1;
                }
                l--;r++;
            }
        }

        return s.substring(stIndex,stIndex+maxLength);
    }

}
