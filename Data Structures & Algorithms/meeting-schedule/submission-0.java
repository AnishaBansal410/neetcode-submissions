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
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        int i=1;
        while(i<intervals.size()){
            if(intervals.get(i).start<intervals.get(i-1).end){
                return false;
            }
            i++;
        }
        return true;
    }
}
