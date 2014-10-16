public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height.length == 1) return height[0];
        Stack<Integer> stack = new Stack<Integer>();
        //stack.push(0);
        int sum = 0;
        int i = 0;
        for(;i<height.length;i++) {
            if(stack.isEmpty() || height[i] >= height[stack.peek()]) stack.push(i);
            else {
                int tmp = stack.pop();
                sum = Math.max(sum, height[tmp]*(stack.isEmpty() ? i : i-stack.peek()-1));
                i--;
            }
        }
        while(!stack.isEmpty()) {
            int tmp = stack.pop();
            sum = Math.max(sum, height[tmp]*(stack.isEmpty() ? i : i-stack.peek()-1));
        }
        return sum;
    }
}
