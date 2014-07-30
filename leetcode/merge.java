public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while(i >=0 && j >=0) {
			if(A[i] < B[j]) {
				A[k] = B[j];
				j--;
			} else {
				A[k] = A[i];
				i--;
			}
			k--;
		}
		if(j >= 0) {
			while(k >= 0) {
				A[k] = B[j];
				k--;
				j--;
			}
		}
    }
}
