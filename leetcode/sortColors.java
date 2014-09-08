public class Solution {
    public void sortColors(int[] A) {
        int l = 0;
		int r = A.length-1;
		while(l < r && A[l] == 0) l++;
		if(l == r) return;
		while(l < r && A[r] == 2) r--;
		if(l == r) return;
		int i = l;
		while(i <= r) {
			if(A[i] == 0 && i > l) {
				swap(A, i, l);
				l++;
			}
			else if(A[i] == 2) {
				swap(A, i, r);
				r--;
			}
			else i++;
		}
    }
	public void swap(int[] A, int i, int x) {
		int tmp = A[i];
		A[i] = A[x];
		A[x] = tmp;
	}
}
