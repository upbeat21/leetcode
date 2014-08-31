public class Solution {
    public int minCut(String s) {
        if(s == null || s == "") return -1;
        boolean[][] a = new boolean[s.length()][s.length()];
        int[] D = new int[s.length()+1];
        for(int i=0;i<D.length;i++) {
            D[i] = s.length() - 1 - i;
        }
        for(int i=s.length()-1;i>=0;i--) {
            for(int j=i;j<s.length();j++) {
                if(s.charAt(i) == s.charAt(j) && (j-i<2 || a[i+1][j-1])) {
                    a[i][j] = true;
                    D[i] = Math.min(D[i], 1+D[j+1]);
                }
            }
        }
        return D[0];
    }
}
