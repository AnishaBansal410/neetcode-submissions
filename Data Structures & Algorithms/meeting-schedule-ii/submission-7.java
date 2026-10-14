/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        // Collections.sort(intervals, (a, b) -> Integer.compare(a.end, b.end));
        // List<Integer> tmp = new ArrayList<>();
        // int rooms=1;
        // int i=1;
        // while(i<intervals.size()){
        //     if(intervals.get(i).start<intervals.get(i-1).end && tmp.size()!=0 && tmp.get(tmp.size()-1)>intervals.get(i).start){
        //         rooms++;
        //     }
        //     tmp.add(intervals.get(i-1).end);
        //     i++;
        // }
        // return rooms;
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(Interval interval:intervals){
            map.merge(interval.start, 1, Integer::sum);
            map.merge(interval.end, -1, Integer::sum);
        }

        int minrooms = 0;
        int curr=0;
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            curr+=e.getValue();
            minrooms=Math.max(minrooms,curr);
        }

        return minrooms;
    }
}
