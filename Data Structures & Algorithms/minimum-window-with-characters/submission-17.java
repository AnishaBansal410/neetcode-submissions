class Solution {
    public String minWindow(String s, String t) {
        String ans = "";

        if(s.length()<t.length()){
            return ans;
        }

        int[] freq = new int[128];

        int reqd = 0;

        for(int i=0;i<t.length();i++){
            if(freq[t.charAt(i)-'A']==0){
                reqd++;
            }
            freq[t.charAt(i)-'A']++;
        }

        int formed = 0;
        int[] freqS = new int[128];

        int i=0,j=0;

        while(j<s.length()){
            freqS[s.charAt(j)-'A']++;
            if(freqS[s.charAt(j)-'A'] == freq[s.charAt(j)-'A']){
                formed++;
            }
            while(formed==reqd){
                if(ans.length()==0){
                    ans=s.substring(i,j+1);
                }
                if(ans.length()>j-i+1){
                    ans = s.substring(i,j+1);
                }
                if(freqS[s.charAt(i)-'A']==freq[s.charAt(i)-'A']){
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
