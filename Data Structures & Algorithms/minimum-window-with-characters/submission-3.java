class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()){
            return "";
        }
        int[] freqT = new int[128];
        int reqd=0;
        for(int i=0;i<t.length();i++){
            if(freqT[t.charAt(i)]==0){
                reqd++;
            }
            freqT[t.charAt(i)]++;
        }
        int[] freqWindow = new int[128];
        int i=0,j=0;
        int formed=0;
        String ans="";
        while(j<s.length()){
            freqWindow[s.charAt(j)]++;
            if(freqWindow[s.charAt(j)] == freqT[s.charAt(j)]){
                formed++;
            }
            while(formed==reqd){
                if(j+1-i<ans.length()){
                    ans=s.substring(i,j+1);
                }
                if(ans.equals("")){
                    ans=s.substring(i,j+1);
                }
                if(freqT[s.charAt(i)]!=0 && freqT[s.charAt(i)]==freqWindow[s.charAt(i)]){
                    formed--;
                }
                freqWindow[s.charAt(i)]--;
                i++;
            }
            j++;
        }
        return ans;

    }
}
