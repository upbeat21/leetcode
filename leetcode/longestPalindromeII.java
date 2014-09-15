public class Solution {
    public String longestPalindrome(String s) {
        if(s == null) return null;
        boolean[][] a = new boolean[s.length()][s.length()];
        int max = 0;
        int start = 0;
        int end = 0;
        for(int i=0;i<s.length();i++) {
            for(int j=0;j<i;j++) {
                if(s.charAt(i) == s.charAt(j) && (i-j<2 || a[j+1][i-1])) {
                    a[j][i] = true;
                    if(max < i - j + 1) {
                        max = i - j + 1;
                        start = j;
                        end = i;
                    }
                }
                a[i][i] = true;
            }
        }
        return s.substring(start, end + 1);
    }
}
