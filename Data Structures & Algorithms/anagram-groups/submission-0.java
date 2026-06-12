class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans =new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String s = String.valueOf(c);
            if(map.containsKey(s)){
                map.get(s).add(strs[i]);
            }
            else{
                List<String> list=new ArrayList<>();
                list.add(strs[i]);
                map.put(s,list);
            }
        }
        for(Map.Entry<String,List<String>> e : map.entrySet()){
            ans.add(e.getValue());
        } 
        return ans;
    }
}
