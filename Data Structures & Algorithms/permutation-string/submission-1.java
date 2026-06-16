class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr = new int[26];
        if(s1.length()>s2.length()){
            return false;
        }
        for(int i=0;i<s1.length();i++){
            arr[s1.charAt(i)-'a']++;
            arr[s2.charAt(i)-'a']--;
        }
        if(checkArray(arr)){
            return true;
        }
        int i=s1.length();
        int j=0;
        while(i<s2.length()){
            arr[s2.charAt(j)-'a']++;
            arr[s2.charAt(i)-'a']--;
            if(checkArray(arr)){
                return true;
            }
            i++;j++;
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
