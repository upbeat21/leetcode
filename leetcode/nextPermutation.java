public class Solution {
    public void nextPermutation(int[] num) {
        if(num.length == 0) return;
        int index = -1;
        for(int i=num.length-1;i>=1;i--) {
            if(num[i-1] < num[i]) {
                index = i-1;
                break;
            }
        }
        if(index != -1) {
            for(int i=num.length-1;i>=0;i--) {
                if(num[i] > num[index]) {
                    int tmp = num[index];
                    num[index] = num[i];
                    num[i] = tmp;
                    break;
                }
            }
        }
        reverse(num, index+1, num.length-1);
    }
    public void reverse(int[] num, int l, int r) {
        while(l < r) {
            int tmp = num[l];
            num[l] = num[r];
            num[r] = tmp;
            l++;
            r--;
        }
    }
}   
