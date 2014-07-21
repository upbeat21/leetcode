public class Solution {
    public int firstMissingPositive(int[] A) {
		int i=0;
		while(i < A.length) {
			if(A[i] >= 1 && A[i] <= A.length && A[i]-1 != i && A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
			else i++;
		}
		for(int k=0;k<A.length;k++) {
			if(A[k]-1 != k) return k+1;
		}
		return A.length+1;
    }
	public void swap(int[] A, int a, int b) {
		int tmp = A[a];
		A[a] = A[b];
		A[b] = tmp;
	}
}
