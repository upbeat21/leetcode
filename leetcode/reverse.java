public class Solution {
    public int reverse(int x) {
        int r = 0;
        while(x != 0) {
            int t = x / 10;
            int k = x - t * 10;
            x = x / 10;
            r = r * 10 + k;
        }
        return r;
    }
}
