public class Solution {
    public int climbStairs(int n) {
		if(n == 1) return 1;
		if(n == 2) return 2;
        int a = 1;
		int b = 2;
		int m = 0;
		for(int i=3;i<=n;i++) {
			m = a + b;
			a = b;
			b = m;
		}
		return m;
    }
}
