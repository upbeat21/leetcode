public class Solution {
    public int candy(int[] ratings) {
        int[] a = new int[ratings.length];
        for(int i=0;i<ratings.length;i++) a[i] = 1;
        for(int i=1;i<ratings.length;i++) {
            if(ratings[i] > ratings[i-1])
                a[i] = a[i-1] + 1;
        }
        for(int i=ratings.length-1;i>=1;i--) {
            if(ratings[i-1] > ratings[i] && a[i-1] <= a[i])
                a[i-1] = a[i] + 1;
        }
        int result = 0;
        for(int c : a) result += c;
        return result;
    }
}
