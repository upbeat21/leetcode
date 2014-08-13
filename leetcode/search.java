public class Solution {
    public int search(int[] A, int target) {
        int l = 0;
        int r = A.length - 1;
        while(l <= r) {
            int m = (l + r) / 2;
            int n = A[m];
            if(n >= A[0]) {
                if(target == n) return m;
                else if(target > n) l = m + 1;
                else {
                    if(target >= A[0]) r = m - 1;
                    else l = m + 1;
                }
            } else {
                if(target == n) return m;
                else if(target < n) r = m - 1;
                else {
                    if(target >= A[0]) r = m - 1;
                    else l = m + 1;
                }
            }
        }
        return -1;
    }
}
