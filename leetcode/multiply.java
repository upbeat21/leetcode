public class Solution {
    public String multiply(String num1, String num2) {
		String result = "0";
		for(int i=num2.length()-1;i>=0;i--) {
			int n = num2.charAt(i) - '0';
			result = add(result, mul(num1, n, num2.length()-1-i));
		}
		while(result.length() >= 2 && result.charAt(0) == '0') result = result.substring(1);
		return result;
    }
	public String mul(String num1, int n, int i) {
		String result = "";
		int carry = 0;
		for(int k=num1.length()-1;k>=0;k--) {
			int m = num1.charAt(k) - '0';
			int d = (m * n + carry) % 10;
			carry = (m * n + carry) / 10;
			result = d + result;
		}
		if(carry != 0) result = carry + result;
		for(int k=0;k<i;k++) result += "0";
		return result;
	}
	public String add(String a, String b) {
		String result = "";
		int l = a.length() - 1;
		int r = b.length() - 1;
		int carry = 0;
		while(l >=0 || r >= 0) {
			int m = l >= 0 ? a.charAt(l) - '0' : 0;
			int n = r >= 0 ? b.charAt(r) - '0' : 0;
			int d = (m + n + carry) % 10;
			carry = (m + n + carry) / 10;
			result = d + result;
			l--;
			r--;
		}
		if(carry != 0) result = carry + result;
		return result;
	}
}
