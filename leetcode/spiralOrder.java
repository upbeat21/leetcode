public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        int r = matrix.length-1;
        if(r < 0) return list;
        int c = matrix[0].length-1;
        int p = 0;
        int q = 0;
        while(p <= r && q <= c) {
            for(int i=q;i<=c;i++) list.add(matrix[p][i]);
            p++;
            for(int i=p;i<=r;i++) list.add(matrix[i][c]);
            c--;
            if(p <= r) {
                for(int i=c;i>=q;i--) list.add(matrix[r][i]);
                r--;
            }
            if(q <= c) {
                for(int i=r;i>=p;i--) list.add(matrix[i][q]);
                q++;
            }
        }
        return list;
    }
}
