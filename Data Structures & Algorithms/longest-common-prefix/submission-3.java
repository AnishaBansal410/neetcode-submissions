class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1=strs[0];
        String s2=strs[strs.length-1];
        String ans="";
        int i=0;
        while(i<s1.length() && s1.charAt(i)==s2.charAt(i)){
            ans+=s1.charAt(i++);
        }
        return ans;
    }
}