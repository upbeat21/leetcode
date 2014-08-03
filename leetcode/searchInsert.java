public class Solution {
    public int searchInsert(int[] A, int target) {
        if(target <= A[0]) return 0;
        if(target > A[A.length-1]) return A.length;
        int l = 0;
        int r = A.length-1;
        while(l <= r) {
            int m = (l + r) / 2;
            if(target > A[m]) l = m + 1;
            else if(target <= A[m]) r = m - 1;
        }
        return l;
    }
}
