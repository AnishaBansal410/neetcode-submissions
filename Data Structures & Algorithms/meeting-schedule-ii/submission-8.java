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
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(Interval i : intervals){
            map.put(i.start,map.getOrDefault(i.start,0)+1);
            map.put(i.end,map.getOrDefault(i.end,0)-1);
        }

        int maxRooms=0;
        int currRooms = 0;

        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            currRooms+=e.getValue();
            maxRooms=Math.max(maxRooms,currRooms);
        }

        return maxRooms;
    }
}
