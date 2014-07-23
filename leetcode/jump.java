public class Solution {
    public int jump(int[] A) {
        int result = 0;
		int lastCanArrive = 0;
		int canArrive = 0;
		for(int i=0;i<A.length;i++) {
			if(i > lastCanArrive) {
				result++;
				lastCanArrive = canArrive;
			}
			if(canArrive < A[i] + i) canArrive = A[i] + i;
		}
		return result;
    }
}
