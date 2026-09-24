class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()){
            return "";
        }
        int reqd = 0;
        int[] freqT = new int[128];

        for(int i=0;i<t.length();i++){
            if(freqT[t.charAt(i)]==0){
                reqd++;
            }
            freqT[t.charAt(i)]++;
        }

        int[] freqWindow = new int[128];

        String ans = "";

        int i=0,j=0;
        int formed=0;

        while(j<s.length()){
            freqWindow[s.charAt(j)]++;
            if(freqWindow[s.charAt(j)]==freqT[s.charAt(j)]){
                formed++;
            }
            while(formed==reqd){
                if(j-i+1<ans.length() || ans.equals("")){
                    ans = s.substring(i,j+1);
                }
                if(freqT[s.charAt(i)]!=0 && freqWindow[s.charAt(i)]==freqT[s.charAt(i)]){
                    formed--;
                }
                freqWindow[s.charAt(i)]--;
                i++;
            }
            j++;

        }
        return ans;
    }

    public boolean checkArray(int[] arr1,int[] arr2){
        for(int i=0;i<26;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
}
