public class Solution {
    public String longestPalindrome(String s) {
		if(s == null || s.length() == 0) return null;
		int max = 1;
		String r = s.substring(0, 1);
		for(int i=0;i<s.length();i++) {
			int j = 1;
			int len = 1;
			while(i-j >= 0 && i+j <s.length()) {
				if(s.charAt(i-j) == s.charAt(i+j)) {
					len += 2;
					if(max < len) {
						max = len;
						r = s.substring(i-j, i+j+1);
					}
					j++;
				} else break;
			}
			if(i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
				len = 2;
				j = 1;
				if(max < len) {
					max = len;
					r = s.substring(i, i+2);
				}
				while(i+1+j < s.length() && i-j >= 0) {
					if(s.charAt(i+1+j) == s.charAt(i-j)) {
						len += 2;
						if(max < len) {
							max = len;
							r = s.substring(i-j, i+j+2);
						}
						j++;
					} else break;
				}
			}
		}
		return r;
    }
}
