class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        for(int[] num:intervals){
            list.add(num);
        }
        int ans=0;
        int i=0;
        while(i<list.size()-1){
            int j=i+1;
            while(j<list.size() && list.get(j)[0]>=list.get(i)[1]){
                j++;
                i++;
            }
            if(j<list.size()){
                if(list.get(i)[1]>list.get(j)[1]){
                    list.remove(i);
                }
                else{
                    list.remove(j);
                }
                ans++;
            }
            if(i==list.size()-1){
                break;
            }
        }
        return ans;
    }
}
