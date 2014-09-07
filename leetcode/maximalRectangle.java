public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if(row == 0) return 0;
        int col = matrix[0].length;
        int[][] a = new int[row][col];
        for(int i=0;i<row;i++) {
            int m = 0;
            for(int j=0;j<col;j++) {
                if(matrix[i][j] == '1') m++;
                else m = 0;
                a[i][j] = m;
            }
        }
        int max = 0;
        for(int i=row-1;i>=0;i--) {
            for(int j=col-1;j>=0;j--) {
                int width = a[i][j];
                int height = 1;
                int localMax = width;
                for(int k=i-1;k>=0;k--) {
                    if(a[k][j] == 0) break;
                    width = Math.min(width, a[k][j]);
                    height++;
                    localMax = Math.max(localMax, width*height);
                }
                max = Math.max(max, localMax);
            }
            
        }
        return max;
    }
}
