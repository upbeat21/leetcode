public class Solution {
    public static String minWindow(String S, String T) {
        int[] needToFind = new int[256];
        int[] hasFound = new int[256];
        for(int i=0;i<T.length();i++) {
            needToFind[T.charAt(i)]++;
        }
        int count = 0;
        int start = 0;
        int end = 0;
        for(;end < S.length();end++) {
            char c = S.charAt(end);
            if(needToFind[c] == 0) continue;
            hasFound[c]++;
            if(hasFound[c] <= needToFind[c]) {
                count++;
                if(count == T.length()) break;
            }
        }
        if(count != T.length()) return "";
        while(hasFound[S.charAt(start)] <= 0 || hasFound[S.charAt(start)] > needToFind[S.charAt(start)]) {
            hasFound[S.charAt(start)]--;
            start++;
        }
        String result = S.substring(start, end+1);
        int min = result.length();
        for(end=end+1;end<S.length();end++) {
            char c = S.charAt(end);
            if(needToFind[c] == 0) continue;
            hasFound[c]++;
            while(hasFound[S.charAt(start)] <= 0 || hasFound[S.charAt(start)] > needToFind[S.charAt(start)]) {
                hasFound[S.charAt(start)]--;
                start++;
            }
            if(min > end - start + 1) {
                min = end - start + 1;
                result = S.substring(start, end+1);
            }
        }
        return result;
    }
    public static void main(String[] args) {
    	System.out.println(minWindow("abcabdebac", "cda"));
    }
}
