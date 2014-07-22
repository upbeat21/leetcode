public class Solution {
    public boolean canJump(int[] A) {
        int canArrive = 0;
		for(int i=0;i<=canArrive && canArrive <= A.length - 1;i++) {
			if(i + A[i] > canArrive) canArrive = i + A[i];
		}
		return canArrive >= A.length - 1;
    }
	
}
