class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans=0;

        int i=0,j=0;

        HashSet<Character> set = new HashSet<>();

        while(j<s.length()){
            while(i<j && set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }
            ans = Math.max(ans,j-i+1);
            set.add(s.charAt(j));
            j++;
        }

        return ans;
    }
}
