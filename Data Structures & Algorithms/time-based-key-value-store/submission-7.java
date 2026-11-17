class TimeMap {

    HashMap<String,List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key,k->new ArrayList<>()).add(new Pair(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }

        List<Pair> arr = map.get(key);

        int st=0,end=arr.size()-1;
        int ans = -1;

        while(st<=end){
            int mid = st+(end-st)/2;

            if(arr.get(mid).time==timestamp){
                return arr.get(mid).value;
            }

            if(arr.get(mid).time<timestamp){
                ans=mid;
                st=mid+1;
            }
            else{
                end=mid-1;
            }
        }

        if(ans==-1){
            return "";
        }
        
        return arr.get(ans).value;
    }
}

class Pair{
    int time;
    String value;

    Pair(int t,String v){
        time = t;
        value = v;
    }
}