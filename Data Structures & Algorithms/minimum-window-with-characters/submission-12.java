class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        String ans = "";
        int[] freqT = new int[128];
        int reqd=0;
        for(int i=0;i<t.length();i++){
            if(freqT[t.charAt(i)]==0){
                reqd++;
            }
            freqT[t.charAt(i)]++;
        }

        int[] window = new int[128];
        int formed = 0;
        int i=0,j=0;
        while(i<s.length()){
            window[s.charAt(i)]++;
            if(freqT[s.charAt(i)]==window[s.charAt(i)]){
                formed++;
            }
            while(j<=i && formed==reqd){
                if(ans.length()==0){
                    ans = s.substring(j,i+1);
                }
                if(i-j+1<ans.length()){
                    ans = s.substring(j,i+1);
                }
                if(freqT[s.charAt(j)]==window[s.charAt(j)]){
                    formed--;
                }
                window[s.charAt(j)]--;
                j++;
            }
            i++;
        }
        return ans;
    }
}
