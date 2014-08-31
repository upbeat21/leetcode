public class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        if(row == 0) return;
        int col = board[0].length;
        Queue<Integer> rIndex = new LinkedList<Integer>();
        Queue<Integer> cIndex = new LinkedList<Integer>();
        for(int i=0;i<col;i++) {
            if(board[0][i] == 'O') {
                rIndex.offer(0);
                cIndex.offer(i);
                bfs(board, rIndex, cIndex);
            }
            if(board[row-1][i] == 'O') {
                rIndex.offer(row-1);
                cIndex.offer(i);
                bfs(board, rIndex, cIndex);
            }
        }
        for(int i=1;i<row-1;i++) {
            if(board[i][0] == 'O') {
                rIndex.offer(i);
                cIndex.offer(0);
                bfs(board, rIndex, cIndex);
            }
            if(board[i][col-1] == 'O') {
                rIndex.offer(i);
                cIndex.offer(col-1);
                bfs(board, rIndex, cIndex);
            }
        }
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(board[i][j] == 'P') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
    public void bfs(char[][] board, Queue<Integer> rIndex, Queue<Integer> cIndex) {
        while(!rIndex.isEmpty()) {
            int i = rIndex.poll();
            int j = cIndex.poll();
            if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') continue;
            board[i][j] = 'P';
            rIndex.offer(i-1);
            cIndex.offer(j);
            rIndex.offer(i+1);
            cIndex.offer(j);
            rIndex.offer(i);
            cIndex.offer(j-1);
            rIndex.offer(i);
            cIndex.offer(j+1);
        }
    }
}
