class Solution {
    public int characterReplacement(String s, int k) {
        int length=0;
        for(char i='A';i<='Z';i++){
            length = Math.max(length,maxLength(s,i,k));
        }
        return length;
    }

    public int maxLength(String s, char c,int k){
        int i=0,j=0;
        int length=0;

        while(j<s.length()){
            if(s.charAt(j)!=c){
                k--;
            }
            while(k<0 && i<s.length()){
                if(s.charAt(i)!=c){
                    k++;
                }
                i++;
            }
            length = Math.max(length,j-i+1);
            j++;
        }

        return length;
    }
}
