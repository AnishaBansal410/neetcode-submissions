class Solution {
    public boolean validPalindrome(String s) {
        if(isPalindrome(s)){
            return true;
        }
        for(int i=0;i<s.length();i++){
            String st = s.substring(0,i)+s.substring(i+1);
            if(isPalindrome(st)){
                return true;
            }
        }
        return false;
    }
    public boolean isPalindrome(String s){
        s=s.toLowerCase();
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
                continue;
            }
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }
}