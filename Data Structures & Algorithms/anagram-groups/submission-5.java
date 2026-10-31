class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> ans = new ArrayList<>();

        HashMap<String,List<String>> map = new HashMap<>();

        for(String s:strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String tmp = String.valueOf(arr);
            map.computeIfAbsent(tmp, k -> new ArrayList<>()).add(s);
            
        }

        for(Map.Entry<String,List<String>> e : map.entrySet()){
            ans.add(e.getValue());
        }

        return ans;
    }
}
