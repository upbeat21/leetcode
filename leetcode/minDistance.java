public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] a = new int[word1.length()+1][word2.length()+1];
        a[0][0] = 0;
        for(int k=1;k<a.length;k++) a[k][0] = k;
        for(int k=1;k<a[0].length;k++) a[0][k] = k;
        for(int i=1;i<a.length;i++) {
            for(int j=1;j<a[0].length;j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) a[i][j] = a[i-1][j-1];
                else a[i][j] = a[i-1][j-1] + 1;
                a[i][j] = Math.min(a[i][j], Math.min(a[i-1][j]+1, a[i][j-1]+1));
            }
        }
        return a[word1.length()][word2.length()];
    }
}
