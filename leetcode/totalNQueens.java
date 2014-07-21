public class Solution {
	int result = 0;
    public int totalNQueens(int n) {
        if(n == 0) return 0;
		helper(n, 0, new int[n]);
		return result;
    }
	public void helper(int n, int start, int[] row) {
		if(start == n) {
			result++;
			return;
		}
		for(int i=0;i<n;i++) {
			row[start] = i;
			if(isValid(row, start)) {
				helper(n, start+1, row);
			}
		}
	}
	public boolean isValid(int[] row, int end) {
		for(int i=0;i<end;i++) {
			if(row[i] == row[end]) return false;
			if(end - i == Math.abs(row[i]-row[end])) return false;
		}
		return true;
	}
}
