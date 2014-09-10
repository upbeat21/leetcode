public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] a = new int[n][n];
		if(n == 0) return a;
		int p = 0;
		int q = 0;
		int row = n-1;
		int col = n-1;
		int k = 1;
		while(k <= n * n) {
			for(int i=q;i<=col;i++) {
				a[p][i] = k;
				k++;
			}
			p++;
			for(int i=p;i<=row;i++) {
				a[i][col] = k;
				k++;
			}
			col--;
			if(p <= row) {
				for(int i=col;i>=q;i--) {
					a[row][i] = k;
					k++;
				}
				row--;
			}
			if(q <= col) {
				for(int i=row;i>=p;i--) {
					a[i][q] = k;
					k++;
				}
				q++;
			}
		}
		return a;
    }
}
