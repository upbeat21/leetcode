public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        String result = "";
        String sub = "";
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) != ' ') {
                sub += s.charAt(i);
            } else {
                if(sub.length() > 0) result = " " + sub + result;
                sub = "";
            }
        }
        if(sub.length() != 0) result = sub + result;
        if(result.length() > 0 && result.charAt(0) == ' ') result = result.substring(1);
        return result;
    }
}
