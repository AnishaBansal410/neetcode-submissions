class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26];
        if(s1.length()>s2.length()){
            return false;
        }
        for(int i=0;i<s1.length();i++){
            count[s1.charAt(i)-'a']++;
            count[s2.charAt(i)-'a']--;
        }
        if(checkArray(count)){
            return true;
        }
        int j=0;
        for(int i=s1.length();i<s2.length();i++){
            count[s2.charAt(i)-'a']--;
            count[s2.charAt(j++)-'a']++;
            if(checkArray(count)){
                return true;
            }
        }
        return false;
    }

    public boolean checkArray(int[] arr){
        for(int i:arr)
        {
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}
