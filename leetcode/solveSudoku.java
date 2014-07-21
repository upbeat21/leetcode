public class Solution {
    public void solveSudoku(char[][] board) {
        int row = board.length;
		if(row != 9) return;
		int col = board[0].length;
		if(col != 9) return;
		helper(board, 0, 0);
    }
	public boolean helper(char[][] board, int i, int j) {
		if(j == 9) {
			i++;
			if(i == 9) return true;
			j = 0;
		}	
		if(board[i][j] == '.') {
			for(int k=1;k<=9;k++) {
				board[i][j] = (char)(k+'0');
				if(check(board, i, j)) {
					if(helper(board, i, j+1)) return true;
				}
			}
			board[i][j] = '.';
			return false;
		} else {
			return helper(board, i, j+1);
		}
	}
	public boolean check(char[][] board, int i, int j) {
		for(int k=0;k<9;k++) {
			if(k != j && board[i][j] == board[i][k]) return false;
		}
		for(int k=0;k<9;k++) {
			if(k != i && board[i][j] == board[k][j]) return false;
		}
		for(int row=i/3*3;row<i/3*3+3;row++) {
			for(int col=j/3*3;col<j/3*3+3;col++) {
				if((row != i && col != j) && board[i][j] == board[row][col]) return false;
			}
		}
		return true;
	}
}
