class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        int i=0;

        List<int[]> res = new ArrayList<>();

        while(i<intervals.length){
            int j=i+1;
            int currEnd = intervals[i][1];

            while(j<intervals.length && intervals[j][0]<=currEnd){
                currEnd = Math.max(intervals[i][1],intervals[j][1]);
                j++;
            }

            res.add(new int[]{intervals[i][0],currEnd});
            i=j;
        }

        int[][] ans = new int[res.size()][2];
        i=0;

        while(i<res.size()){
            ans[i] = res.get(i);
            i++;
        }

        return ans;
    }
}
