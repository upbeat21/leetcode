public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int min = Integer.MAX_VALUE;
        int re = 0;
        for(int l=0;l<num.length;l++) {
            int m = l + 1;
            int r = num.length - 1;
            while(m < r) {
                int p = num[m];
                int q = num[r];
                int sum = p + q + num[l];
                if(Math.abs(sum-target) < min) {
                    min = Math.abs(sum-target);
                    re = sum;
                }
                if(sum < target) {
                    while(m++ < r && num[m] == p);
                } else if(sum > target) {
                    while(r-- > m && num[r] == q);
                } else {
                    return re;
                }
            }
        }
        return re;
    }
}
