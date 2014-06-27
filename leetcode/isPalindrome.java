public class Solution {
    public boolean isPalindrome(int x) {
        int y = x;
        int r = 0;
        while(y > 0) {
            int t = y / 10;
            int k = y - t * 10;
            r = r * 10 + k;
            y = y / 10;
        }
        return r == x;
    }
}
