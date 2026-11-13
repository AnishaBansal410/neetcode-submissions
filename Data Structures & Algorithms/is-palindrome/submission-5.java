class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int st=0,end=s.length()-1;
        while(st<=end){
            if(!Character.isLetterOrDigit(s.charAt(st))){
                st++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(end))){
                end--;
                continue;
            }
            if(s.charAt(st)!=s.charAt(end)){
                return false;
            }
            st++;
            end--;
        }

        return true;
    }
}
