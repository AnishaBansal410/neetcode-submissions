class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] dict = new int[26];
        for(int i=0;i<order.length();i++){
            dict[order.charAt(i)-'a']=i;
        }

        for(int i=0;i<words.length-1;i++){
            String s1 = words[i];
            String s2 = words[i+1];

            int j=0;

            while(j<s1.length()){
                if(j==s2.length()){
                    return false;
                }

                if(s1.charAt(j)!=s2.charAt(j) && dict[s1.charAt(j)-'a']>dict[s2.charAt(j)-'a']){
                    return false;
                }

                if(s1.charAt(j)!=s2.charAt(j) && dict[s1.charAt(j)-'a']<dict[s2.charAt(j)-'a']){
                    break;
                }
                j++;
            }
        }

        return true;
    }
}