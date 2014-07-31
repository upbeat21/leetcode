public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        boolean[][] a = new boolean[s1.length()+1][s2.length()+1];
        a[0][0] = true;
        for(int i=0;i<s1.length();i++) {
            a[i+1][0] = a[i][0] && s1.charAt(i) == s3.charAt(i);
        }
        for(int i=0;i<s2.length();i++) {
            a[0][i+1] = a[0][i] && s2.charAt(i) == s3.charAt(i);
        }
        for(int i=0;i<s1.length();i++) {
            for(int j=0;j<s2.length();j++) {
                a[i+1][j+1] = (a[i][j+1] && s1.charAt(i) == s3.charAt(i+j+1)) || (a[i+1][j] && s2.charAt(j) == s3.charAt(i+j+1));
            }
        }
        return a[s1.length()][s2.length()];
    }
}
