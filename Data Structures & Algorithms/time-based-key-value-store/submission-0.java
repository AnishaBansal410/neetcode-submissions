class TimeMap {

    HashMap<String,TreeMap<Integer,String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new TreeMap<>());
        }
        map.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        String ans="";
        TreeMap<Integer,String> m = map.get(key);
        for(Map.Entry<Integer,String> e : m.entrySet()){
            if(e.getKey()<=timestamp){
                ans=e.getValue();
            }
        }
        return ans;
    }
}
