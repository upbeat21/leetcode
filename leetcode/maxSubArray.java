public class Solution {
    public int maxSubArray(int[] A) {
        int sum = 0;
        int max = A[0];
        for(int i=0;i<A.length;i++) {
            if(sum > 0) {
                sum += A[i];
            }
            else sum = A[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
