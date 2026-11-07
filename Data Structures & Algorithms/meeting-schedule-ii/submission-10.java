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
        List<int[]> arr = new ArrayList<>();

        for(Interval i : intervals){
            arr.add(new int[]{i.start,1});
            arr.add(new int[]{i.end,-1});
        }

        Collections.sort(arr, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return Integer.compare(a[0], b[0]);
        });

        int maxRooms=0;
        int active = 0;

        for(int[] i : arr){
            active+=i[1];
            maxRooms = Math.max(active,maxRooms);
        }

        return maxRooms;
    }
}
