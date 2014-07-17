public class Solution {
    public List<String[]> solveNQueens(int n) {
		List<String[]> list = new ArrayList<String[]>();
		helper(list, 0, n, new int[n]);
		return list;
    }
	public void helper(List<String[]> list, int start, int n, int[] row) {
		if(start == n) {
			String[] s = new String[n];
			for(int i=0;i<n;i++) {
				StringBuilder sb = new StringBuilder();
				for(int j=0;j<n;j++) {
					if(j == row[i]) sb.append('Q');
					else sb.append('.');
				}
				s[i] = sb.toString();
			}
			list.add(s);
			return;
		}
		for(int i=0;i<n;i++) {
			row[start] = i;
			if(check(row, start)) helper(list, start+1, n, row);
		}
	}
	public boolean check(int[] row, int end) {
		for(int i=0;i<end;i++) {
			if(row[i] == row[end] || (end-i == Math.abs(row[i]-row[end]))) return false;
		}
		return true;
	}
}
