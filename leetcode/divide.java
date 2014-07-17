public class Solution {
    public int divide(int dividend, int divisor) {
        int digits = 0;
		int result = 0;
		if(divisor == 0) return Integer.MAX_VALUE;
		if(dividend == Integer.MIN_VALUE) {
			dividend += Math.abs(divisor);
			result += 1;
		}
		if(divisor == Integer.MIN_VALUE) return result;
		int k = 1;
		if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) k = -1;
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		while(divisor <= (dividend >> 1)) {
			divisor = divisor << 1;
			digits++;
		}
		while(digits >= 0) {
			if(dividend >= divisor) {
				dividend -= divisor;
				result += 1 << digits;
			}
			digits--;
			divisor = divisor >> 1;
		}	
		return k * result;
    }
}
