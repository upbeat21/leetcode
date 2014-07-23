/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        Map<Double, Integer> map = new HashMap<Double, Integer>();
		int result = 0;
		for(int i=0;i<points.length;i++) {
			map.clear();
			Point p1 = points[i];
			int dup = 0;
			for(int j=0;j<points.length;j++) {
				if(j == i) continue;
				Point p2 = points[j];
				if(p2.x == p1.x && p2.y == p1.y) {
					dup++;
					continue;
				}
				if(p2.x == p1.x) {
					double k = Double.MAX_VALUE;
					if(map.containsKey(k)) {
						map.put(k, map.get(k) + 1);
					} else {
						map.put(Double.MAX_VALUE, 2);
					}
				}
				if(p2.x > p1.x) {
					double k = 1.0 * (p2.y - p1.y) / (p2.x - p1.x);
					if(map.containsKey(k)) {
						map.put(k, map.get(k) + 1);
					} else {
						map.put(k, 2);
					}
				}
			}
			int max = 0;
			if(map.size() == 0) max = 1;
			else {
				Iterator<Double> it = map.keySet().iterator();
				while(it.hasNext()) {
					double k = it.next();
					max = Math.max(map.get(k), max);
				}
			}
			while(dup > 0) {
				max++;
				dup--;
			}
			result = Math.max(result, max);
		}
		return result;
    }
}
