/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals.size() == 0) {
			intervals.add(newInterval);
			return intervals;
		}
		List<Interval> list = new ArrayList<Interval>();
		for(int i=0;i<intervals.size();i++) {
			Interval interval = intervals.get(i);
			if(newInterval == null) {
				list.add(interval);
				continue;
			}
			if(newInterval.start > interval.end) list.add(interval);
			else if(newInterval.end < interval.start) {
				list.add(newInterval);
				list.add(interval);
				newInterval = null;
			} else {
				newInterval.start = Math.min(newInterval.start, interval.start);
				newInterval.end = Math.max(newInterval.end, interval.end);
			}
		}
		if(newInterval != null) list.add(newInterval);
		return list;
    }
}
