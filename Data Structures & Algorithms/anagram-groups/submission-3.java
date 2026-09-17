class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String tmp = String.valueOf(arr);

            if(map.containsKey(tmp)){
                map.get(tmp).add(s);
            }
            else{
                map.put(tmp,new ArrayList<>());
                map.get(tmp).add(s);
            }
        }
        List<List<String>> ans = new ArrayList<>();

        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            ans.add(entry.getValue());
        }

        return ans;
    }
}
