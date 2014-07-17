public class Solution {
	public boolean isValidSudoku(char[][] board) {
		ArrayList<boolean[]> rowchecker = new ArrayList<boolean[]>();
		ArrayList<boolean[]> colchecker = new ArrayList<boolean[]>();
		ArrayList<boolean[]> blockchecker = new ArrayList<boolean[]>();
		for(int i=0;i<9;i++) {
			rowchecker.add(new boolean[9]);
			colchecker.add(new boolean[9]);
			blockchecker.add(new boolean[9]);
		}
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(board[i][j] == '.') continue;
				int c = board[i][j] - '1';
				if(rowchecker.get(i)[c] || colchecker.get(j)[c] || blockchecker.get(i/3*3 + j/3)[c]) return false;
				else {
					rowchecker.get(i)[c] = true;
					colchecker.get(j)[c] = true;
					blockchecker.get(i/3*3 + j/3)[c] = true;
				}
			}
		}
		return true;
	}
}
