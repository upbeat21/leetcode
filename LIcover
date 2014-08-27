public class Solution {
	public static class Interval {
		int start;
		int end;
		public Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
	public int cover(List<Interval> list) {
		if(list == null || list.size() == 0) return 0;
		Collections.sort(list, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				if(a.start == b.start) return a.end - b.end;
				return a.start - b.start;
			}
		})
		int result = 0;
		Interval a = list.get(0);
		for(int i=1;i<list.size();i++) {
			Interval b = list.get(i);
			if(b.start > a.end) {
				result += a.end - a.start;
				a = b;
			} else {
				a.end = b.end;
			}
		}
		result += a.end - a.start;
		return result;
	}
}
