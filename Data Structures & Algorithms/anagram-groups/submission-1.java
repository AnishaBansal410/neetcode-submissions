class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans =new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String temp = String.valueOf(c);
            if(map.containsKey(temp)){
                map.get(temp).add(strs[i]);
            }
            else{
                map.put(temp,new ArrayList<>());
                map.get(temp).add(strs[i]);
            }
        }

        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
