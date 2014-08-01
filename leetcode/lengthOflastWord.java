public class Solution {
    public int lengthOfLastWord(String s) {
        int result = 0;
        int backup = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) != ' ') {
                result++;
                backup = result;
            }
            else result = 0;
        }
        return backup;
    }
}
