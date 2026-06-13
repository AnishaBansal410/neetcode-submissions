class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();

        int i=0;
        while(i<intervals.length){
            int end=intervals[i][1];
            int j=i+1;
            while(j<intervals.length && intervals[j][0]<=end){
                end=Math.max(end,intervals[j][1]);
                j++;
            }
            list.add(new int[]{intervals[i][0],end});
            i=j;
        }
        int[][] ans = new int[list.size()][2];
        int k=0;
        for(int[] num:list){
            ans[k++]=num;
        }
        return ans;
    }
}
