public class Solution {
    public int maxArea(int[] height) {
        if(height.length == 0) return 0;
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while(l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            max = Math.max(area, max);
            if(height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
