class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }

        List<Integer> ans = new ArrayList<>();

        int currend=0;

        int size=0;

        for(int i=0;i<s.length();i++){
            size++;
            currend=Math.max(currend,map.get(s.charAt(i)));
            if(i==currend){
                ans.add(size);
                size=0;
            }
        }

        return ans;
    }
}
