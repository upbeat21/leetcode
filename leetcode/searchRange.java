public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] result = {-1, -1};
		int l = binarySearch(A, target-0.5);
		if(l >= A.length || A[l] != target) return result;
		int r = binarySearch(A, target+0.5);
		result[0] = l;
		result[1] = r - 1;
		return result;
    }
	public int binarySearch(int[] A, double t) {
		int l = 0;
		int r = A.length - 1;
		while(l <= r) {
			int m = (l + r) / 2;
			if(A[m] == t) return m;
			else if(A[m] > t) r = m - 1;
			else l = m + 1;
		}
		return l;
	}
}
