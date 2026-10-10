class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()){
            return "";
        }
        int[] freqT = new int[128];
        int[] freqS = new int[128];
        int reqd=0;
        for(int i=0;i<t.length();i++){
            if(freqT[t.charAt(i)-'A']==0){
                reqd++;
            }
            freqT[t.charAt(i)-'A']++;
        }

        int formed=0;

        int i=0,j=0;
        String ans = "";

        while(j<s.length()){
            freqS[s.charAt(j)-'A']++;
            if(freqS[s.charAt(j)-'A'] == freqT[s.charAt(j)-'A']){
                formed++;
            }
            while(formed==reqd){
                if(ans==""){
                    ans = s.substring(i,j+1);
                }
                if(j-i+1<ans.length()){
                    ans = s.substring(i,j+1);
                }
                if(freqS[s.charAt(i)-'A']==freqT[s.charAt(i)-'A']){
                    formed--;
                }
                freqS[s.charAt(i)-'A']--;
                i++;
            }
            j++;
        }

        return ans;
    }
}
