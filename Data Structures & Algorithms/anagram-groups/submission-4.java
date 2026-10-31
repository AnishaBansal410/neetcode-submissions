class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> ans = new ArrayList<>();

        HashMap<String,List<String>> map = new HashMap<>();

        for(String s:strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            if(map.containsKey(String.valueOf(arr))){
                map.get(String.valueOf(arr)).add(s);
                continue;
            }
            map.put(String.valueOf(arr),new ArrayList<>());
            map.get(String.valueOf(arr)).add(s);
        }

        for(Map.Entry<String,List<String>> e : map.entrySet()){
            ans.add(e.getValue());
        }

        return ans;
    }
}
