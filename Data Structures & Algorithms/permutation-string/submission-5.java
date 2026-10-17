class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];

        if(s2.length()<s1.length()){
            return false;
        }

        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
            freq[s2.charAt(i)-'a']--;
        }

        if(checkArray(freq)){
            return true;
        }

        int i=0,j=s1.length();

        while(j<s2.length()){
            freq[s2.charAt(j)-'a']--;
            freq[s2.charAt(i)-'a']++;
            if(checkArray(freq)){
                return true;
            }
            i++;
            j++;
        }

        return false;
    }

    public boolean checkArray(int[] arr){
        for(int i:arr){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}
