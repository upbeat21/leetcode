public class Solution {
    public int trap(int[] A) {
		if(A.length == 0) return 0;
		int result = 0;
        int[] maxL = new int[A.length];
		int[] maxR = new int[A.length];
		maxL[0] = 0;
		maxR[A.length-1] = 0;
		int max = -1;
		for(int i=1;i<A.length;i++) {
			maxL[i] = Math.max(A[i-1], maxL[i-1]);
		}
		for(int i=A.length-2;i>=0;i--) {
			maxR[i] = Math.max(A[i+1], maxR[i+1]);
		}
		for(int i=0;i<A.length;i++) {
			int tmp = Math.min(maxL[i], maxR[i]) - A[i];
			if(tmp > 0) result += tmp;
		}	
		return result;
    }
}
