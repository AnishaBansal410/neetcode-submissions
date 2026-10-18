class TimeMap {

    HashMap<String,List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new ArrayList<>());
        }
        map.get(key).add(new Pair(timestamp,value));
    }
    
    public String get(String key, int timestamp) {

        if(!map.containsKey(key)){
            return "";
        }

        List<Pair> list = map.get(key);
        Collections.sort(list,(a,b)->a.time-b.time);

        int st=0,end=list.size()-1;
        String ans="";
        while(st<=end){
            int mid=st+(end-st)/2;

            if(list.get(mid).time==timestamp){
                return list.get(mid).value;
            }

            if(list.get(mid).time>timestamp){
                end=mid-1;
            }
            else{
                ans=list.get(mid).value;
                st=mid+1;
            }
        }
        
        return ans;
    }
}

static class Pair{
    int time;
    String value;

    Pair(int t,String s){
        this.time=t;
        this.value=s;
    }
}
