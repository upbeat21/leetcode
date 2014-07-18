public class Solution {
	ArrayList<boolean[]> rowchecker = new ArrayList<boolean[]>();
	ArrayList<boolean[]> colchecker = new ArrayList<boolean[]>();
	ArrayList<boolean[]> blockchecker = new ArrayList<boolean[]>();
    public void solveSudoku(char[][] board) {
        for(int i=0;i<9;i++) {
			rowchecker.add(new boolean[9]);
			colchecker.add(new boolean[9]);
			blockchecker.add(new boolean[9]);
		}
		helper(board, 0, 0);
    }
	public void helper(char[][] board, int i, int j) {
		if(j == 9) {
			i++;
			j = 0;
			if(i == 9) return;
		}
		for(int p=0;p<9;p++) {
			if(board[i][j] == '.') {
				if(check(board, i, j, p)) {
					board[i][j] = (char)(p + '1');
					rowchecker.get(i)[p] = true;
					colchecker.get(j)[p] = true;
					blockchecker.get(i/3*3+j/3)[p] = true;
					helper(board, i, j+1);
				}
			} else {
				int c = board[i][j] - '1';
				rowchecker.get(i)[c] = true;
				colchecker.get(j)[c] = true;
				blockchecker.get(i/3*3+j/3)[c] = true;
				helper(board, i, j+1);
			}
		}
	}
	public boolean check(char[][] board, int i, int j, int c) {
		if(rowchecker.get(i)[c] || colchecker.get(j)[c] || blockchecker.get(i/3*3+j/3)[c]) return false;
		return true;
	}
}
