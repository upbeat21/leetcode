public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        int[] pathSum = new int[triangle.size()];
        int rownum = triangle.size();
        for(int i=rownum-1;i>=0;i--) {
            for(int j=0;j<i+1;j++) {
                if(i == rownum-1) {
                    pathSum[j] = triangle.get(i).get(j);
                } else {
                    pathSum[j] = Math.min(pathSum[j], pathSum[j+1]) + triangle.get(i).get(j);
                }
            }
        }
        return pathSum[0];
    }
}
