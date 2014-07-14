public class Solution {
    public int removeDuplicates(int[] A) {
		if(A.length == 0) return 0;
        int index = 1;
		int n = A[0];
		for(int i=1;i<A.length;i++) {
			if(n != A[i]) {
				A[index] = A[i];
				index++;
				n = A[i];
			} 
		}
		return index;
    }
}
