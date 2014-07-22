public class Solution {
    public static String multiply(String num1, String num2) {
		String result = "0";
		for(int i=num2.length()-1;i>=0;i--) {
			int n = num2.charAt(i) - '0';
			result = add(result, mul(num1, n, num2.length()-1-i));
		}
		return result;
    }
	public static String mul(String num1, int n, int i) {
		String result = "";
		int carry = 0;
		for(int k=num1.length()-1;k>=0;k--) {
			int m = num1.charAt(k) - '0';
			int d = ((m * n + carry) % 10);
			result = d + result;
			carry = (m * n + carry) / 10;
		}
		if(carry != 0) result = carry + result;
		for(int k=0;k<i;k++) result += "0";
		return result;
	}
	public static String add(String a, String b) {
		int carry = 0;
		String result = "";
		int i = a.length() - 1;
		int j = b.length() - 1;
		while(i >= 0 && j >= 0) {
			int m = a.charAt(i) - '0';
			int n = b.charAt(j) - '0';
			int d = (m + n + carry) % 10;
			carry = (m + n + carry) / 10;
			result = d + result;
			i--;
			j--;
		}
		if(j >= 0) {
			for(int k=j;k>=0;k--) {
				int m = b.charAt(k) - '0';
				int d = (m + carry) % 10;
				carry = (m + carry) / 10;
				result = d + result;
			}
		} else if(i >= 0) {
			for(int k=i;k>=0;k--) {
				int m = a.charAt(k) - '0';
				int d = (m + carry) % 10;
				carry = (m + carry) / 10;
				result = d + result;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		String a = "123";
		String b = "456";
		System.out.println(multiply(a, b));
	}
}
